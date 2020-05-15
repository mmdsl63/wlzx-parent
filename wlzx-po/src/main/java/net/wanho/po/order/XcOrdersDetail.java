package net.wanho.po.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data

@TableName("wlzx-orders_detail")

public class XcOrdersDetail implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
   @TableId
    private String id;

    private String orderNumber;
    private String itemId;
    private Integer itemNum;
    private Float itemPrice;
    private String valid;
    private Date startTime;
    private Date endTime;
}
