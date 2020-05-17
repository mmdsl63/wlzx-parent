package net.wanho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.mapper.CourseTeachplanMapper;
import net.wanho.po.course.Teachplan;
import net.wanho.po.course.ext.TeachplanNode;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 18:44
 **/
@Service
public class CourseTeachplanService extends ServiceImpl<CourseTeachplanMapper, Teachplan> {

    /**
     * 查询课程计划信息
     * @param courseId
     * @return
     */
    public TeachplanNode findTeachplanList(String courseId) {
        return baseMapper.findTeachplanList(courseId);
    }

}
