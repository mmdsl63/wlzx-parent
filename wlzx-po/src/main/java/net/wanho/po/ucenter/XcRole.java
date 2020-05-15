package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@TableName("wlzx-role")

public class XcRole {

   @TableId
    private String id;
    private String roleName;
    private String role_code;
    private String description;
    private String status;
    private Date create_time;
    private Date updateTime;


}
