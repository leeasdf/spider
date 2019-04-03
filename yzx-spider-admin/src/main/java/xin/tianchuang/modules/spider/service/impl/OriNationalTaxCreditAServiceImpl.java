package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.OriNationalTaxCreditADao;
import xin.tianchuang.modules.spider.entity.OriNationalTaxCreditAEntity;
import xin.tianchuang.modules.spider.service.OriNationalTaxCreditAService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("oriNationalTaxCreditAService")
public class OriNationalTaxCreditAServiceImpl extends ServiceImpl<OriNationalTaxCreditADao, OriNationalTaxCreditAEntity> implements OriNationalTaxCreditAService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OriNationalTaxCreditAEntity> page = this.selectPage(
                new Query<OriNationalTaxCreditAEntity>(params).getPage(),
                new EntityWrapper<OriNationalTaxCreditAEntity>()
        );

        return new PageUtils(page);
    }

}
