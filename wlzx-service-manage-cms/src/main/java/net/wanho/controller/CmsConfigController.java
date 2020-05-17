package net.wanho.controller;

import net.wanho.api.cms.CmsConfigControllerApi;
import net.wanho.common.web.BaseController;
import net.wanho.po.cms.CmsConfig;
import net.wanho.service.CmsConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-13 11:30
 **/
@RestController
@RequestMapping("/cms/config")
public class CmsConfigController extends BaseController implements CmsConfigControllerApi {

    @Resource
    private CmsConfigService service;

    @Override
    @GetMapping("/getmodel/{id}")
    public CmsConfig getmodel(@PathVariable String id) {
        return service.getConfigAndModelByConfigId(id);
    }

}
