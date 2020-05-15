package net.wanho.po.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("wlzx-company_user")

public class XcCompanyUser implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
   @TableId
    private String id;
    private String companyId;
    private String userId;


}
