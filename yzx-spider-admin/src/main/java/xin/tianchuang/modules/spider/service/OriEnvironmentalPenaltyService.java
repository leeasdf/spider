package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriEnvironmentalPenaltyEntity;

/**
 * 环境行政处罚(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriEnvironmentalPenaltyService extends IService<OriEnvironmentalPenaltyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

