package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriEnterpriseTaxTaxpayerDao;
import xin.tianchuang.modules.spider.entity.OriEnterpriseTaxTaxpayerEntity;
import xin.tianchuang.modules.spider.service.OriEnterpriseTaxTaxpayerService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriEnterpriseTaxTaxpayerService")
public class OriEnterpriseTaxTaxpayerServiceImpl extends ServiceImpl<OriEnterpriseTaxTaxpayerDao, OriEnterpriseTaxTaxpayerEntity> implements OriEnterpriseTaxTaxpayerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriEnterpriseTaxTaxpayerEntity> page = this.selectPage(
                new Query<OriEnterpriseTaxTaxpayerEntity>(params).getPage(),
                new EntityWrapper<OriEnterpriseTaxTaxpayerEntity>()
        );

        return new PageUtils(page);
    }

}
