package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@TableName("wlzx-user")

public class XcUser {

   @TableId
    private String id;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String utype;
    private String birthday;
    private String userpic;
    private String sex;
    private String email;
    private String phone;
    private String status;
    private Date createTime;
    private Date updateTime;


}
