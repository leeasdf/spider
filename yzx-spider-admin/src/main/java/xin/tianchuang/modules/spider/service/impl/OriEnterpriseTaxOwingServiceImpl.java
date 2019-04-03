package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriEnterpriseTaxOwingDao;
import xin.tianchuang.modules.spider.entity.OriEnterpriseTaxOwingEntity;
import xin.tianchuang.modules.spider.service.OriEnterpriseTaxOwingService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriEnterpriseTaxOwingService")
public class OriEnterpriseTaxOwingServiceImpl extends ServiceImpl<OriEnterpriseTaxOwingDao, OriEnterpriseTaxOwingEntity> implements OriEnterpriseTaxOwingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriEnterpriseTaxOwingEntity> page = this.selectPage(
                new Query<OriEnterpriseTaxOwingEntity>(params).getPage(),
                new EntityWrapper<OriEnterpriseTaxOwingEntity>()
        );

        return new PageUtils(page);
    }

}
