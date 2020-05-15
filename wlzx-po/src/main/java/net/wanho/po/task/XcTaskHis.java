package net.wanho.po.task;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mrt on 2018/4/4.
 */
@Data
@ToString
public class XcTaskHis implements Serializable {

    private String id;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String taskType;
    private String mqExchange;
    private String mqRoutingkey;
    private String requestBody;
    private String version;
    private String status;
}
