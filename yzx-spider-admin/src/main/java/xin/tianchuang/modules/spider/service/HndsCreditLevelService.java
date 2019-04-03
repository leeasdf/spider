package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HndsCreditLevelEntity;

import java.util.Map;

/**
 * 湖南省地方税务局-纳税信用等级信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-21 17:13:05
 */
public interface HndsCreditLevelService extends IService<HndsCreditLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

	HndsCreditLevelEntity selectByTaxNoYearsDate(String taxper,String taxNo, String years, String evaluateDate, String authority);
}

