package net.wanho.po.course;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;


import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class TeachplanMediaPub implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;

    @TableId
    private String teachplanId;

    private String mediaId;

    private String mediaFileOriginalName;

    private String mediaUrl;

    private String courseId;

    private Date timestamp;//时间戳

}
