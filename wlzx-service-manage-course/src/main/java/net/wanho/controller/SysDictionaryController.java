package net.wanho.controller;

import net.wanho.api.sys.SysDictionaryControllerApi;
import net.wanho.common.web.BaseController;
import net.wanho.po.system.SysDictionary;
import net.wanho.service.SysDictionaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 14:53
 **/
@RestController
@RequestMapping("/sys")
public class SysDictionaryController extends BaseController implements SysDictionaryControllerApi {

    @Resource
    private SysDictionaryService service;

    /**
     * 字典
     * @param type
     * @return
     */
    @Override
    @GetMapping("/dictionary/get/{type}")
    public SysDictionary getByType(@PathVariable String type) {
        return service.getByType(type);
    }
}
