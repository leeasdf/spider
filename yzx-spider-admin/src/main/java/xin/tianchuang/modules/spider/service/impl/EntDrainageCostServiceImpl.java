package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntDrainageCostDao;
import xin.tianchuang.modules.spider.entity.EntDrainageCostEntity;
import xin.tianchuang.modules.spider.service.EntDrainageCostService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entDrainageCostService")
public class EntDrainageCostServiceImpl extends ServiceImpl<EntDrainageCostDao, EntDrainageCostEntity> implements EntDrainageCostService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntDrainageCostEntity> page = this.selectPage(
                new Query<EntDrainageCostEntity>(params).getPage(),
                new EntityWrapper<EntDrainageCostEntity>()
        );

        return new PageUtils(page);
    }

}
