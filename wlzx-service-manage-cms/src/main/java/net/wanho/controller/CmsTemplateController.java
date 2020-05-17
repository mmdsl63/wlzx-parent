package net.wanho.controller;

import net.wanho.api.cms.CmsTemplateControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.web.BaseController;
import net.wanho.service.CmsTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 19:52
 **/
@RestController
@RequestMapping("/cms")
public class CmsTemplateController extends BaseController implements CmsTemplateControllerApi {

    @Resource
    private CmsTemplateService service;

    @Override
    @GetMapping("/template/{siteId}")
    public AjaxResult findAllCmsTemplate(@PathVariable String siteId) {
        return success(service.findAllCmsTemplateBySiteId(siteId));
    }

}
