package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.EntLocalTaxCreditInfoDao;
import xin.tianchuang.modules.spider.entity.EntLocalTaxCreditInfoEntity;
import xin.tianchuang.modules.spider.service.EntLocalTaxCreditInfoService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("entLocalTaxCreditInfoService")
public class EntLocalTaxCreditInfoServiceImpl extends ServiceImpl<EntLocalTaxCreditInfoDao, EntLocalTaxCreditInfoEntity> implements EntLocalTaxCreditInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EntLocalTaxCreditInfoEntity> page = this.selectPage(
                new Query<EntLocalTaxCreditInfoEntity>(params).getPage(),
                new EntityWrapper<EntLocalTaxCreditInfoEntity>()
        );

        return new PageUtils(page);
    }

}
