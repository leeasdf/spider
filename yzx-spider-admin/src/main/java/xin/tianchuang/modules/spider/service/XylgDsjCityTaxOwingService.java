package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.XylgDsjCityTaxOwingEntity;

/**
 * 信用麓谷-欠税信息表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:20
 */
public interface XylgDsjCityTaxOwingService extends IService<XylgDsjCityTaxOwingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

