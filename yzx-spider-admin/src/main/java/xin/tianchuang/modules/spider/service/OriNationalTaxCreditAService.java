package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriNationalTaxCreditAEntity;

/**
 * 年度纳税信用A级纳税人名单(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriNationalTaxCreditAService extends IService<OriNationalTaxCreditAEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

