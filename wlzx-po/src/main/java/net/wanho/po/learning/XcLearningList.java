package net.wanho.po.learning;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@TableName("wlzx-learning_list")

public class XcLearningList implements Serializable {
    private static final long serialVersionUID = -916357210051689799L;
   @TableId
    private String id;

    private String courseId;

    private String userId;

    private Date startTime;

    private Date endTime;
    private String status;

}
