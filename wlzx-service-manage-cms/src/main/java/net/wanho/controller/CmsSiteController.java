package net.wanho.controller;

import net.wanho.api.cms.CmsSiteControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.web.BaseController;
import net.wanho.po.cms.CmsSite;
import net.wanho.service.CmsSiteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 19:52
 **/
@RestController
@RequestMapping("/cms")
public class CmsSiteController extends BaseController implements CmsSiteControllerApi {

    @Resource
    private CmsSiteService service;

    @Override
    @GetMapping("/site")
    public AjaxResult findAllCmsSite() {
        return success(service.list());
    }

    @Override
    @PostMapping("/add")
    public AjaxResult addCmsSite(@RequestBody CmsSite cmsSite) {
        service.addCmsSite(cmsSite);
        return success();
    }

    @Override
    @PutMapping("/modify")
    public AjaxResult modifyCmsSite(@RequestBody CmsSite cmsSite) {
        return success(service.updateById(cmsSite));
    }

    @Override
    @GetMapping("/queryCmsSiteById/{id}")
    public AjaxResult queryCmsSiteById(@PathVariable String id) {
        return success(service.getById(id));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public AjaxResult deleteCmsSiteById(@PathVariable String id) {
        return success(service.removeById(id));
    }

}
