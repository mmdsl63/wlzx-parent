package net.wanho.controller;

import net.wanho.api.cms.CmsPageControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.web.BaseController;
import net.wanho.po.cms.CmsPage;
import net.wanho.po.cms.request.QueryPageRequest;
import net.wanho.service.CmsPageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 14:42
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController extends BaseController implements CmsPageControllerApi {

    @Resource
    private CmsPageService cmsPageService;

    /**
     * 分页的接口
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public AjaxResult findList(@PathVariable int page, @PathVariable int size, QueryPageRequest queryPageRequest) {
        return success("查询成功！！！", cmsPageService.findList(page, size, queryPageRequest));
    }

    @Override
    @PostMapping("/add")
    public AjaxResult add(@RequestBody CmsPage cmsPage) {
        cmsPageService.add(cmsPage);
        return success();
    }

    @Override
    @GetMapping("/get/{id}")
    public AjaxResult findById(@PathVariable String id) {
        return success(cmsPageService.getById(id));
    }

    @Override
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody CmsPage cmsPage) {
        return success(cmsPageService.updateById(cmsPage));
    }

    @Override
    @DeleteMapping("/del/{id}")
    public AjaxResult delete(@PathVariable String id) {
        return success(cmsPageService.removeById(id));
    }

    @Override
    @PostMapping("/postPage/{pageId}")
    public AjaxResult post(@PathVariable String pageId) {
        cmsPageService.post(pageId);
        return success();
    }

    @Override
    public AjaxResult save(CmsPage cmsPage) {
        return null;
    }

    @Override
    public AjaxResult postPageQuick(CmsPage cmsPage) {
        return null;
    }
}
