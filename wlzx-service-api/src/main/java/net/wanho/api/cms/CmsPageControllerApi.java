package net.wanho.api.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.po.cms.CmsPage;
import net.wanho.po.cms.request.QueryPageRequest;

@Api(tags = "CmsPage管理接口")
public interface CmsPageControllerApi {
    //页面查询
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页大小", defaultValue = "7")
    })
    public AjaxResult findList(int page, int size, QueryPageRequest queryPageRequest);
    //新增页面
    @ApiOperation("新增页面")
    public AjaxResult add(CmsPage cmsPage);

    //根据页面id查询页面信息
    @ApiOperation("根据页面id查询页面信息")
    @ApiImplicitParam(name = "id", defaultValue = "String")
    public AjaxResult findById(String id);

    //修改页面
    @ApiOperation("修改页面")
    public AjaxResult edit(CmsPage cmsPage);

    //删除页面
    @ApiOperation("删除页面")
    @ApiImplicitParam(name = "id", defaultValue = "String")
    public AjaxResult delete(String id);

    //页面发布
    @ApiOperation("发布页面")
    public AjaxResult post(String pageId);

    @ApiOperation("保存页面")
    public AjaxResult save(CmsPage cmsPage);

    @ApiOperation("一键发布页面")
    public AjaxResult postPageQuick(CmsPage cmsPage);
}