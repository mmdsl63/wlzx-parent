package net.wanho.controller;

import net.wanho.common.exception.ExceptionCast;
import net.wanho.po.cms.response.CmsCode;
import net.wanho.service.CmsPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-13 20:29
 **/
@Controller
@RequestMapping("/cms")
public class CmsPreViewController {

    @Resource
    private CmsPageService service;

    @GetMapping("/preview/{pageId}")
    public void preview (@PathVariable String pageId, HttpServletResponse response) {
        // 得到 html页面
        String html = service.getHtml(pageId);
        // 添加头
        response.addHeader("content-type", "text/html;charset=utf-8");
        try {
            ServletOutputStream os = response.getOutputStream();
            // 将 html变为字节数字写出去
            os.write(html.getBytes("utf-8"));
        } catch (Exception e) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
    }

}
