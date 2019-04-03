package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EnterpriseWaterElectricityDao;
import xin.tianchuang.modules.spider.entity.EnterpriseWaterElectricityEntity;
import xin.tianchuang.modules.spider.service.EnterpriseWaterElectricityService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("enterpriseWaterElectricityService")
public class EnterpriseWaterElectricityServiceImpl extends ServiceImpl<EnterpriseWaterElectricityDao, EnterpriseWaterElectricityEntity> implements EnterpriseWaterElectricityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EnterpriseWaterElectricityEntity> page = this.selectPage(
                new Query<EnterpriseWaterElectricityEntity>(params).getPage(),
                new EntityWrapper<EnterpriseWaterElectricityEntity>()
        );

        return new PageUtils(page);
    }

}
