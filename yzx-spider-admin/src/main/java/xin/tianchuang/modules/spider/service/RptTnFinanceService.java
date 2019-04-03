package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnFinanceEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc企业-融资历史
 *
 * @author hui.deng
 * @email
 * @date 2018-12-04 14:24:47
 */
public interface RptTnFinanceService extends IService<RptTnFinanceEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnFinanceEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
