package net.wanho.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.common.util.StringUtils;
import net.wanho.common.vo.response.PageInfo;
import net.wanho.mapper.CourseMapper;
import net.wanho.po.course.CourseBase;
import net.wanho.po.course.request.CourseListRequest;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-15 09:45
 **/
@Service
public class CourseService extends ServiceImpl<CourseMapper, CourseBase> {

    public PageInfo<CourseBase> findCourseList(int pageNum, int pageSize, CourseListRequest courseListRequest) {

        // 验证
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize < 1) {
            pageSize = 7;
        }
        if (StringUtils.isEmpty(courseListRequest)) {
            courseListRequest = new CourseListRequest();
        }
        // 分页
        IPage<CourseBase> page = new Page<>(pageNum, pageSize);
        // 参数
        QueryWrapper<CourseBase> wrapper = new QueryWrapper<>();
        // todo 现在默认使用 2号公司，之后从登录信息中提取
        courseListRequest.setCompanyId("2");
        wrapper.eq("company_id", courseListRequest.getCompanyId());
        // 分页
        page = page(page, wrapper);
        PageInfo<CourseBase> pageInfo = new PageInfo<>();
        // 分页数据
        pageInfo.setList(page.getRecords());
        // 总记录数
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }
}
