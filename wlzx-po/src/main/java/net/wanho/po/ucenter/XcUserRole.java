package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@TableName("wlzx-user_role")

public class XcUserRole {

   @TableId
    private String id;

    private String userId;
    private String roleId;
    private String creator;
    private Date createTime;

}
