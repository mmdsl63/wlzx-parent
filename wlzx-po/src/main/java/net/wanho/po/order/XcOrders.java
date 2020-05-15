package net.wanho.po.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("wlzx-orders")
public class XcOrders implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @TableId
    private String orderNumber;
    private Float initialPrice;
    private Float price;

    private Date startTime;

    private Date endTime;
    private String status;

    private String userId;

    private String details;

}
