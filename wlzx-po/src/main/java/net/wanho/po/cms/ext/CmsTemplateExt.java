package net.wanho.po.cms.ext;


import net.wanho.po.cms.CmsTemplate;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

}
