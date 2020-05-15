package net.wanho.po.ucenter.ext;


import lombok.Data;
import lombok.ToString;
import net.wanho.po.ucenter.XcMenu;
import net.wanho.po.ucenter.XcUser;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcUserExt extends XcUser {

    //权限信息
    private List<XcMenu> permissions;

    //企业信息
    private String companyId;
}
