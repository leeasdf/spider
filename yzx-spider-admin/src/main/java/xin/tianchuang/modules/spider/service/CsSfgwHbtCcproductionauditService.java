package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtCcproductionauditEntity;

/**
 * 省发改委-强制性清洁生产审核(省环保厅)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwHbtCcproductionauditService extends IService<CsSfgwHbtCcproductionauditEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

