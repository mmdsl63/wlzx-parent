package net.wanho.po.test;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by mrt on 2018/3/30.
 */
@Data
@ToString
@TableName(value = "user_test")
public class UserTest {


    @TableId
    private String id;
    private String name;

    private Date createTime;
}
