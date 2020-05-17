package net.wanho.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.po.course.Teachplan;
import net.wanho.po.course.ext.TeachplanNode;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 18:45
 **/
public interface CourseTeachplanMapper extends BaseMapper<Teachplan> {

    /**
     * 查询课程计划信息
     * @param courseId
     * @return
     */
    TeachplanNode findTeachplanList(String courseId);

}
