package net.wanho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.mapper.CourseMarketMapper;
import net.wanho.po.course.CourseMarket;
import net.wanho.po.course.response.CourseCode;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 17:00
 **/
@Service
public class CourseMarketService extends ServiceImpl<CourseMarketMapper, CourseMarket> {

    /**
     * 更新课程营销信息
     * @param id
     * @param courseMarket
     */
    public void updateCourseMarket(String id, CourseMarket courseMarket) {
        CourseMarket byId = getById(id);
        if (StringUtils.isEmpty(byId)) {
            ExceptionCast.cast(CourseCode.COURSE_MARKET_NOT_FIND);
        }
        // 设置 id
        courseMarket.setId(id);
        // 根据id 修改
        updateById(courseMarket);
    }
}
