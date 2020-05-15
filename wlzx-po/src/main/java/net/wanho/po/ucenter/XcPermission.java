package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@TableName("wlzx-permission")

public class XcPermission {

   @TableId
    private String id;
    private String role_id;
    private String menu_id;
    private Date create_time;


}
