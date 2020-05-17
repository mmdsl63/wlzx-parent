package net.wanho.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.common.vo.response.PageInfo;
import net.wanho.mapper.CmsPageMapper;
import net.wanho.mapper.CmsSiteMapper;
import net.wanho.po.cms.CmsPage;
import net.wanho.po.cms.CmsSite;
import net.wanho.po.cms.CmsTemplate;
import net.wanho.po.cms.request.QueryPageRequest;
import net.wanho.po.cms.response.CmsCode;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 14:48
 **/
@Service
public class CmsPageService extends ServiceImpl<CmsPageMapper, CmsPage> {

    @Resource
    private CmsTemplateService templateService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private FastFileStorageClient fastFileStorageClient;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Value("${wlzx.mq.exchange}")
    private String exchange;

    @Value("${wlzx.mq.routingKey}")
    private String routingKey;

    @Resource
    private CmsPageMapper cmsPageMapper;

    @Resource
    private CmsSiteMapper cmsSiteMapper;

    public PageInfo<CmsPage> findList(int pageNum, int pageSize, QueryPageRequest queryPageRequest) {

        // 验证
        if (pageNum < 1) {
            pageNum = 1;
        }

        if (pageSize < 1) {
            pageSize = 7;
        }

        QueryWrapper<CmsPage> wrapper = new QueryWrapper<>();
        // 站点 id
        if (queryPageRequest.getSiteId() != null && !"".equals(queryPageRequest.getSiteId().trim())) {
            wrapper.eq("site_id", queryPageRequest.getSiteId());
        }
        // 模板 Id
        if (queryPageRequest.getTemplateId() != null && !"".equals(queryPageRequest.getTemplateId().trim())) {
            wrapper.eq("template_id", queryPageRequest.getTemplateId());
        }
        // 页面别名模糊查询
        if (queryPageRequest.getPageAliase() != null && !"".equals(queryPageRequest.getPageAliase().trim())) {
            wrapper.like("page_aliase", queryPageRequest.getPageAliase());
        }
        wrapper.orderByDesc("page_create_time");
        IPage<CmsPage> page = new Page<>(pageNum, pageSize);

        page = page(page, wrapper);

        PageInfo<CmsPage> pageInfo = new PageInfo<>();
        pageInfo.setList(page.getRecords());
        pageInfo.setTotal(page.getTotal());

        return pageInfo;
    }

    public CmsPage add(CmsPage cmsPage) {
        QueryWrapper<CmsPage> wrapper = new QueryWrapper<>();
        wrapper.eq("page_id", cmsPage.getPageId());
        wrapper.eq("page_name", cmsPage.getPageName());
        wrapper.eq("page_web_path", cmsPage.getPageWebPath());

        if (StringUtils.isNotEmpty(getOne(wrapper))) {
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        // 这样 id只能是 uuid，不然会报错
        cmsPage.setPageId(null);
        save(cmsPage);
        return cmsPage;
    }

    public String getHtml(String pageId) {

        // 数据
        Map model = getModelByPageId(pageId);

        // 模板
        String template = getTemplateByPageId(pageId);

        // 页面
        return generateHtml(model, template);
    }

    private String getTemplateByPageId(String pageId) {
        // 通过 pageId得到 cmsPage信息
        CmsPage cmsPage = getById(pageId);
        // 如果没查到 cmsPage信息就抛异常
        if (StringUtils.isEmpty(cmsPage)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        // 通过 模板id 查询模板信息
        CmsTemplate cmsTemplate = templateService.getById(cmsPage.getTemplateId());
        // 如果没查到 cmsTemplate
        if (StringUtils.isEmpty(cmsTemplate)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        // 得到 数据库中的 group1/M00/00/05/wKhkBV3py0iAKJbgAAAH7Gaotxo989.ftl
        String templateContent = cmsTemplate.getTemplateContent();
        // 从开头到 第一个 /结束 前包后不包
        String group = templateContent.substring(0, templateContent.indexOf("/"));
        // 从 第一个 /下一个开始 一直到最后
        String url = templateContent.substring(templateContent.indexOf("/") + 1);
        // 下载文件
        byte[] bytes = fastFileStorageClient.downloadFile(group, url, new DownloadByteArray());
        return new String(bytes);
    }

    private String generateHtml(Map model, String template) {
        // 创建配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 创建模板加载器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", template);
        // 将加载器放到配置对象中
        configuration.setTemplateLoader(stringTemplateLoader);
        try {
            // 从配置中 得到模板
            Template configurationTemplate = configuration.getTemplate("template");
            // 整合 html
            return FreeMarkerTemplateUtils.processTemplateIntoString(configurationTemplate, model);
        } catch (Exception e) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_SAVEHTMLERROR);
        }
        return null;
    }

    private Map getModelByPageId(String pageId) {
        // 通过 pageId得到 cmsPage信息
        CmsPage cmsPage = getById(pageId);
        // 如果没查到 cmsPage信息就抛异常
        if (StringUtils.isEmpty(cmsPage)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        // 返回通过 地址得到的数据
        return restTemplate.getForObject(cmsPage.getDataUrl(), Map.class);
    }

    /**
     * 发布
     *
     * @param pageId
     */
    public void post(String pageId) {

        //将页面静态化文件存储到FastDFs中，同时更新CmsPage里的htmlFilePath属性
        saveHtml(pageId);
        //向MQ发消息
        sendPostPage(pageId);

    }

    /**
     * 发送消息
     * @param pageId
     */
    private void sendPostPage(String pageId) {
        // 发送
        rabbitTemplate.convertAndSend(exchange, routingKey, pageId);
    }

    /**
     * 将页面静态化, 放到文件服务器中
     *
     * @param pageId
     */
    private void saveHtml(String pageId) {
        String html = getHtml(pageId);
        //先得到页面信息
        CmsPage cmsPage = getById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        //将htmlContent保存到fastdfs
        try (InputStream is = new ByteArrayInputStream(html.getBytes())) {
            StorePath storePath = fastFileStorageClient.uploadFile(is, is.available(), "html", null);
            //将html文件id更新到cmsPage中
            cmsPage.setHtmlFilePath(storePath.getGroup() + "/" + storePath.getPath());
            // 更新
            updateById(cmsPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从fastdfs保存html页面 到服务器物理路径
     *
     * @param pageId
     */
    public void savePageToServerPath(String pageId) {

        //根据pageId查询cmsPage
        CmsPage cmsPage = cmsPageMapper.selectById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        // 得到站点id
        String siteId = cmsPage.getSiteId();
        //得到站点的信息
        CmsSite cmsSite = cmsSiteMapper.selectById(siteId);
        if (cmsSite == null) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        // 得到站点的物理路径
        String pagePath = cmsSite.getSitePhysicalPath() + cmsPage.getPagePhysicalPath();
        File file = new File(pagePath);
        //目录不存在时创建
        if (!file.exists()) {
            file.mkdirs();
        }
        //将html文件保存到服务器物理路径上
        FileOutputStream fos = null;
        ByteArrayInputStream bis = null;
        try {
            fos = new FileOutputStream(pagePath + cmsPage.getPageName());

            //从fastDfs读取内容
            String htmlFilePath = cmsPage.getHtmlFilePath();
            String group = htmlFilePath.substring(0, htmlFilePath.indexOf("/"));
            String url = htmlFilePath.substring(htmlFilePath.indexOf("/") + 1);
            byte[] bytes = fastFileStorageClient.downloadFile(group, url, new DownloadByteArray());
            bis = new ByteArrayInputStream(bytes);
            //从fastdfs读取内容保存在本地
            IOUtils.copy(bis, fos);
        } catch (Exception e) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_SAVEHTMLERROR);
        } finally {
            try {
                assert fos != null;
                fos.close();
                assert bis != null;
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
