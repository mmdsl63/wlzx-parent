package net.wanho.listener;

import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.po.cms.CmsPage;
import net.wanho.po.cms.response.CmsCode;
import net.wanho.service.CmsPageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-14 21:45
 **/
@Component
public class PostPageListener {

    @Resource
    private CmsPageService cmsPageService;

    /**
     * 下载文件，保存在本地。
     */
    @RabbitListener(queues = "${wlzx.mq.queue}")
    public void receive(String pageId){
        //校验页面是否合法
        CmsPage cmsPage = cmsPageService.getById(pageId);
        if (StringUtils.isEmpty(cmsPage)) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_ERROR);
        }
        //调用service方法将页面从FastDFS中下载到服务器
        cmsPageService.savePageToServerPath(pageId);
    }

}
