package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwHbtPenaltiesDao;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtPenaltiesEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtPenaltiesService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwHbtPenaltiesService")
public class CsSfgwHbtPenaltiesServiceImpl extends ServiceImpl<CsSfgwHbtPenaltiesDao, CsSfgwHbtPenaltiesEntity> implements CsSfgwHbtPenaltiesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CsSfgwHbtPenaltiesEntity> page = this.selectPage(
                new Query<CsSfgwHbtPenaltiesEntity>(params).getPage(),
                new EntityWrapper<CsSfgwHbtPenaltiesEntity>()
        );

        return new PageUtils(page);
    }

}
