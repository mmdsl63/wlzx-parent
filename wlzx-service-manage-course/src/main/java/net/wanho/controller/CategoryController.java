package net.wanho.controller;

import net.wanho.api.course.CategoryControllerApi;
import net.wanho.common.web.BaseController;
import net.wanho.po.course.ext.CategoryNode;
import net.wanho.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-15 16:20
 **/
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController implements CategoryControllerApi {

    @Resource
    private CategoryService service;

    /**
     * 课程分类
     * @return
     */
    @Override
    @GetMapping("/list")
    public CategoryNode findList() {
        return service.findList();
    }
}
