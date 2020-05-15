package net.wanho.po.portalview;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import net.wanho.po.course.CourseBase;
import net.wanho.po.course.CourseMarket;
import net.wanho.po.course.CoursePic;
import net.wanho.po.course.ext.TeachplanNode;
import net.wanho.po.report.ReportCourse;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@TableName(value = "view_course")
public class ViewCourse implements Serializable{

    @TableId
    private String id;
    private CourseBase courseBase;
    private CourseMarket courseMarket;
    private CoursePic coursePic;
    private TeachplanNode teachplan;
    //课程统计信息
    private ReportCourse reportCourse;

}
