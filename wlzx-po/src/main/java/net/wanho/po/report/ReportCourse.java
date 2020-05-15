package net.wanho.po.report;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@TableName(value = "report_course")
public class ReportCourse {

    private String id;
    private Float evaluation_score;//评价分数
    private Long collect_num;//收藏次数
    private Long play_num;//播放次数
    private Long student_num;//学生人数
    private Long timelength;//课程时长

}
