package xin.tianchuang.modules.spider.service.impl;

import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.XylgTaxpayerCreditResultDao;
import xin.tianchuang.modules.spider.entity.XylgTaxpayerCreditResultEntity;
import xin.tianchuang.modules.spider.service.XylgTaxpayerCreditResultService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("xylgTaxpayerCreditResultService")
public class XylgTaxpayerCreditResultServiceImpl extends ServiceImpl<XylgTaxpayerCreditResultDao, XylgTaxpayerCreditResultEntity> implements XylgTaxpayerCreditResultService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XylgTaxpayerCreditResultEntity> page = this.selectPage(
                new Query<XylgTaxpayerCreditResultEntity>(params).getPage(),
                new EntityWrapper<XylgTaxpayerCreditResultEntity>()
        );

        return new PageUtils(page);
    }

}
