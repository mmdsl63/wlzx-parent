package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName("wlzx-teacher")
public class XcTeacher implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
    @TableId
    private String id;
    private String name;
    private String pic;
    private String intro;
    private String resume;
    private String userId;

}
