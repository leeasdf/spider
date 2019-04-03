package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntDrainageCostEntity;

/**
 * 企业-电费欠缴信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
public interface EntDrainageCostService extends IService<EntDrainageCostEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

