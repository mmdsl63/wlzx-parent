package net.wanho.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.wanho.po.system.SysDictionary;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 14:57
 **/
public interface SysDictionaryMapper extends BaseMapper<SysDictionary> {

    /**
     * 查询类型对应的等级和学习模式
     * @param type
     * @return
     */
    SysDictionary getByType(String type);

}
