package net.wanho.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.po.course.ext.CategoryNode;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-15 16:22
 **/
public interface CategoryMapper extends BaseMapper<CategoryNode> {

    /**
     * 查询所有 Category（类别）
     * @return
     */
    CategoryNode findList();
}
