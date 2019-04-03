package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnClearingEntity;

import java.util.Map;

/**
 * tyc企业-清算信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 10:37:24
 */
public interface RptTnClearingService extends IService<RptTnClearingEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnClearingEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

