package net.wanho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.mapper.SysDictionaryMapper;
import net.wanho.po.system.SysDictionary;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 14:56
 **/
@Service
public class SysDictionaryService extends ServiceImpl<SysDictionaryMapper, SysDictionary> {

    /**
     * 通过字典 类型拿到具体的等级还有学习模式
     * @param type
     * @return
     */
    public SysDictionary getByType(String type) {
        return baseMapper.getByType(type);
    }
}
