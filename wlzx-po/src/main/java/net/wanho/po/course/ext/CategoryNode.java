package net.wanho.po.course.ext;


import lombok.Data;
import net.wanho.po.course.Category;

import java.util.List;


@Data
public class CategoryNode extends Category {
    List<CategoryNode> children;
}
