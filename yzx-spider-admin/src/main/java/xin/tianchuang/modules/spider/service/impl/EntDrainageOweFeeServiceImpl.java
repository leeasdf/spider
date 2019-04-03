package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntDrainageOweFeeDao;
import xin.tianchuang.modules.spider.entity.EntDrainageOweFeeEntity;
import xin.tianchuang.modules.spider.service.EntDrainageOweFeeService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entDrainageOweFeeService")
public class EntDrainageOweFeeServiceImpl extends ServiceImpl<EntDrainageOweFeeDao, EntDrainageOweFeeEntity> implements EntDrainageOweFeeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntDrainageOweFeeEntity> page = this.selectPage(
                new Query<EntDrainageOweFeeEntity>(params).getPage(),
                new EntityWrapper<EntDrainageOweFeeEntity>()
        );

        return new PageUtils(page);
    }

}
