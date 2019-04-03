package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtEpinformationEntity;

/**
 * 省发改委-排污许可证信息(省环保厅)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwHbtEpinformationService extends IService<CsSfgwHbtEpinformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

