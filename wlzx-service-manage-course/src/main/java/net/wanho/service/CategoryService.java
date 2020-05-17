package net.wanho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.mapper.CategoryMapper;
import net.wanho.po.course.ext.CategoryNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-15 16:22
 **/
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, CategoryNode> {

    /**
     * 课程分类
     * @return
     */
    public CategoryNode findList() {
        return baseMapper.findList();
    }
}
