package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriEnvironmentalPenaltyDao;
import xin.tianchuang.modules.spider.entity.OriEnvironmentalPenaltyEntity;
import xin.tianchuang.modules.spider.service.OriEnvironmentalPenaltyService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriEnvironmentalPenaltyService")
public class OriEnvironmentalPenaltyServiceImpl extends ServiceImpl<OriEnvironmentalPenaltyDao, OriEnvironmentalPenaltyEntity> implements OriEnvironmentalPenaltyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriEnvironmentalPenaltyEntity> page = this.selectPage(
                new Query<OriEnvironmentalPenaltyEntity>(params).getPage(),
                new EntityWrapper<OriEnvironmentalPenaltyEntity>()
        );

        return new PageUtils(page);
    }

}
