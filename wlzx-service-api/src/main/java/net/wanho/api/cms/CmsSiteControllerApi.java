package net.wanho.api.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.po.cms.CmsSite;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "cms站点管理接口")
public interface CmsSiteControllerApi {

    //查询站点信息
    @ApiOperation("查询站点信息")
    AjaxResult findAllCmsSite();

    @ApiOperation("添加站点信息")
    AjaxResult addCmsSite(CmsSite cmsSite);

    @ApiOperation("修改站点信息")
    AjaxResult modifyCmsSite(CmsSite cmsSite);

    @ApiOperation("查询站点信息通过 id")
    @ApiImplicitParam(name = "id", defaultValue = "String")
    AjaxResult queryCmsSiteById(String id);

    @ApiOperation("删除站点信息通过 id")
    @ApiImplicitParam(name = "id", defaultValue = "String")
    AjaxResult deleteCmsSiteById(String id);

}
