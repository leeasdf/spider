package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnInvestEventEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc企业-投资事件
 *
 * @author hui.deng
 * @email
 * @date 2018-12-04 14:24:46
 */
public interface RptTnInvestEventService extends IService<RptTnInvestEventEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnInvestEventEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
