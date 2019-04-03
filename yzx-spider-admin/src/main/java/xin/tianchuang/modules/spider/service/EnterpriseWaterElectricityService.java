package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EnterpriseWaterElectricityEntity;

/**
 * 企业水电数据
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface EnterpriseWaterElectricityService extends IService<EnterpriseWaterElectricityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

