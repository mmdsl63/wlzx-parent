package net.wanho.po.task;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mrt on 2018/4/4.
 */
@Data
public class XcTask implements Serializable {

   @TableId
    private String id;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String taskType;
    private String mqExchange;
    private String mqRoutingkey;
    private String requestBody;
    private Integer version;
    private String status;
    private String errormsg;
}
