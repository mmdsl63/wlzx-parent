package net.wanho.po.ucenter.ext;


import net.wanho.po.course.ext.CategoryNode;
import lombok.Data;
import lombok.ToString;
import net.wanho.po.ucenter.XcMenu;


import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
