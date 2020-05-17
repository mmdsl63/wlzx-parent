package net.wanho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.mapper.CmsConfigMapper;
import net.wanho.po.cms.CmsConfig;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-13 10:37
 **/
@Service
public class CmsConfigService extends ServiceImpl<CmsConfigMapper, CmsConfig> {

    public CmsConfig getConfigAndModelByConfigId(String id) {
        return baseMapper.getConfigAndModelByConfigId(id);
    }

}
