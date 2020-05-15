package net.wanho.api.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.po.cms.CmsTemplate;

/**
 * @author ZhuXuFan
 */
@Api(tags = "cms 模板相关接口")
public interface CmsTemplateControllerApi {

    //查询模板信息
    @ApiOperation("查询模板信息")
    AjaxResult findAllCmsTemplate(String siteId);

}
