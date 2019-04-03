package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.XylgTaxpayerCreditResultEntity;

/**
 * 信用麓谷-纳税信用结果表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
public interface XylgTaxpayerCreditResultService extends IService<XylgTaxpayerCreditResultEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

