package net.wanho.po.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName("wlzx-orders_pay")
public class XcOrdersPay implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @TableId
    private String id;
    private String orderNumber;
    private String payNumber;
    private String status;

}
