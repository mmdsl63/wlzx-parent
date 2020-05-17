package net.wanho.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.mapper.CmsTemplateMapper;
import net.wanho.po.cms.CmsTemplate;
import net.wanho.po.cms.response.CmsCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 20:42
 **/
@Service
public class CmsTemplateService extends ServiceImpl<CmsTemplateMapper, CmsTemplate> {

    /**
     * 添加
     * @param cmsTemplate
     * @return
     */
    public CmsTemplate addCmsTemplate(CmsTemplate cmsTemplate) {
        QueryWrapper<CmsTemplate> wrapper = new QueryWrapper<>();
        wrapper.eq("template_id", cmsTemplate.getTemplateId());
        wrapper.eq("template_name", cmsTemplate.getTemplateName());
        wrapper.eq("template_content", cmsTemplate.getTemplateContent());
        if (StringUtils.isNotEmpty(getOne(wrapper))) {
            ExceptionCast.cast(CmsCode.valueOf("模板不能一样！！！"));
        }
        cmsTemplate.setTemplateId(null);
        save(cmsTemplate);
        return cmsTemplate;
    }

    /**
     * 根据站点 id查询所有模板
     * @param siteId
     * @return
     */
    public List<CmsTemplate> findAllCmsTemplateBySiteId(String siteId) {
        QueryWrapper<CmsTemplate> wrapper = new QueryWrapper<>();
        wrapper.eq("site_id", siteId);
        return list(wrapper);
    }
}
