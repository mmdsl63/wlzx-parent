package net.wanho.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.common.vo.response.PageInfo;
import net.wanho.mapper.CmsSiteMapper;
import net.wanho.po.cms.CmsSite;
import net.wanho.po.cms.response.CmsCode;
import org.springframework.stereotype.Service;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-11 19:54
 **/
@Service
public class CmsSiteService extends ServiceImpl<CmsSiteMapper, CmsSite> {

    /**
     * 添加站点信息
     * @param cmsSite
     */
    public CmsSite addCmsSite(CmsSite cmsSite) {
        QueryWrapper<CmsSite> wrapper = new QueryWrapper<>();
        wrapper.eq("site_id", cmsSite.getSiteId());
        wrapper.eq("site_name", cmsSite.getSiteName());
        wrapper.eq("site_domain", cmsSite.getSiteDomain());
        wrapper.eq("site_web_path", cmsSite.getSiteWebPath());
        if (StringUtils.isNotEmpty(getOne(wrapper))) {
            ExceptionCast.cast(CmsCode.valueOf("站点不能重复"));

        }
        cmsSite.setSiteId(null);
        save(cmsSite);
        return cmsSite;
    }


}

