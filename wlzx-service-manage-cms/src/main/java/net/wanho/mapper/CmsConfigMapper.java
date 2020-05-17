package net.wanho.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.po.cms.CmsConfig;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-13 10:36
 **/
public interface CmsConfigMapper extends BaseMapper<CmsConfig> {

    /**
     * 根据 id查询模板和 配置信息
     * @param id
     * @return
     */
    CmsConfig getConfigAndModelByConfigId(String id);

}
