package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.XylgDsjCityTaxOwingDao;
import xin.tianchuang.modules.spider.entity.XylgDsjCityTaxOwingEntity;
import xin.tianchuang.modules.spider.service.XylgDsjCityTaxOwingService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("xylgDsjCityTaxOwingService")
public class XylgDsjCityTaxOwingServiceImpl extends ServiceImpl<XylgDsjCityTaxOwingDao, XylgDsjCityTaxOwingEntity> implements XylgDsjCityTaxOwingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XylgDsjCityTaxOwingEntity> page = this.selectPage(
                new Query<XylgDsjCityTaxOwingEntity>(params).getPage(),
                new EntityWrapper<XylgDsjCityTaxOwingEntity>()
        );

        return new PageUtils(page);
    }

}
