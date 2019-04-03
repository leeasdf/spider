package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwHbtSjzxGxXzcfDao;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtSjzxGxXzcfEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtSjzxGxXzcfService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwHbtSjzxGxXzcfService")
public class CsSfgwHbtSjzxGxXzcfServiceImpl extends ServiceImpl<CsSfgwHbtSjzxGxXzcfDao, CsSfgwHbtSjzxGxXzcfEntity> implements CsSfgwHbtSjzxGxXzcfService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwHbtSjzxGxXzcfEntity> page = this.selectPage(
                new Query<CsSfgwHbtSjzxGxXzcfEntity>(params).getPage(),
                new EntityWrapper<CsSfgwHbtSjzxGxXzcfEntity>()
        );

        return new PageUtils(page);
    }

}
