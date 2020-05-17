package net.wanho.controller;

import net.wanho.api.course.CourseControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.vo.response.PageInfo;
import net.wanho.common.web.BaseController;
import net.wanho.po.course.*;
import net.wanho.po.course.ext.CourseView;
import net.wanho.po.course.ext.TeachplanNode;
import net.wanho.po.course.request.CourseListRequest;
import net.wanho.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-15 09:36
 **/
@RestController
@RequestMapping("/course")
public class CourseController extends BaseController implements CourseControllerApi {

    @Resource
    private CourseService service;

    @Override
    @GetMapping("/courseBase/list/{page}/{size}")
    public AjaxResult findCourseList(@PathVariable() int page, @PathVariable int size, CourseListRequest courseListRequest) {
        PageInfo<CourseBase> list = service.findCourseList(page, size, courseListRequest);
        return success(list);
    }

    @Override
    public TeachplanNode findTeachplanList(String courseId) {
        return null;
    }

    @Override
    public AjaxResult addTeachplan(Teachplan teachplan) {
        return null;
    }

    @Override
    public AjaxResult addCourseBase(CourseBase courseBase) {
        return null;
    }

    @Override
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException {
        return null;
    }

    @Override
    public AjaxResult updateCourseBase(String id, CourseBase courseBase) {
        return null;
    }

    @Override
    public CourseMarket getCourseMarketById(String courseId) {
        return null;
    }

    @Override
    public AjaxResult updateCourseMarket(String id, CourseMarket courseMarket) {
        return null;
    }

    @Override
    public AjaxResult addCoursePic(String courseId, String pic) {
        return null;
    }

    @Override
    public CoursePic findCoursePic(String courseId) {
        return null;
    }

    @Override
    public AjaxResult deleteCoursePic(String courseId) {
        return null;
    }

    @Override
    public CourseView courseView(String id) {
        return null;
    }

    @Override
    public AjaxResult preview(String id) {
        return null;
    }

    @Override
    public AjaxResult publish(String id) {
        return null;
    }

    @Override
    public AjaxResult saveMedia(TeachplanMedia teachplanMedia) {
        return null;
    }

}
