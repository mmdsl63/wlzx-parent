package net.wanho.controller;

import net.wanho.api.course.CourseControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.vo.response.PageInfo;
import net.wanho.common.web.BaseController;
import net.wanho.po.course.*;
import net.wanho.po.course.ext.CourseView;
import net.wanho.po.course.ext.TeachplanNode;
import net.wanho.po.course.request.CourseListRequest;
import net.wanho.service.CourseMarketService;
import net.wanho.service.CourseService;
import net.wanho.service.CourseTeachplanService;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private CourseMarketService marketService;

    @Resource
    private CourseTeachplanService teachplanService;

    /**
     * 数据字典
     * @param page
     * @param size
     * @param courseListRequest
     * @return
     */
    @Override
    @GetMapping("/courseBase/list/{page}/{size}")
    public AjaxResult findCourseList(@PathVariable() int page, @PathVariable int size, CourseListRequest courseListRequest) {
        PageInfo<CourseBase> list = service.findCourseList(page, size, courseListRequest);
        return success(list);
    }

    /**
     * 新增课程喜喜
     * @param courseBase
     * @return
     */
    @Override
    @PostMapping("/coursebase/add")
    public AjaxResult addCourseBase(@RequestBody CourseBase courseBase) {
        service.addCourseBase(courseBase);
        return success();
    }

    /**
     * 修改回填
     * @param courseId
     * @return
     * @throws RuntimeException
     */
    @Override
    @GetMapping("/courseBase/get/{courseId}")
    public CourseBase getCourseBaseById(@PathVariable String courseId) throws RuntimeException {
        return service.getById(courseId);
    }

    /**
     * 修改
     * @param id
     * @param courseBase
     * @return
     */
    @Override
    @PutMapping("/courseBase/update/{id}")
    public AjaxResult updateCourseBase(@PathVariable String id, @RequestBody CourseBase courseBase) {
        service.updateCourseBase(id, courseBase);
        return success();
    }

    /**
     * 课程营销回填
     * @param courseId
     * @return
     */
    @Override
    @GetMapping("/courseMarket/get/{courseId}")
    public CourseMarket getCourseMarketById(@PathVariable String courseId) {
        return marketService.getById(courseId);
    }

    /**
     * 更新课程营销信息
     * @param id
     * @param courseMarket
     * @return
     */
    @Override
    @PostMapping("/courseMarket/update/{id}")
    public AjaxResult updateCourseMarket(@PathVariable String id, @RequestBody CourseMarket courseMarket) {
        marketService.updateCourseMarket(id, courseMarket);
        return success();
    }

    /**
     * 课程计划
     * @param courseId
     * @return
     */
    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable String courseId) {
        return teachplanService.findTeachplanList(courseId);
    }

    @Override
    public AjaxResult addTeachplan(Teachplan teachplan) {
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
