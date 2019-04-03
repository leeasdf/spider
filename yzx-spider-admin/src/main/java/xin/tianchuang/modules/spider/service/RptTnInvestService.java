package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnInvestEntity;

/**
 * 对外投资
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:22
 */
public interface RptTnInvestService extends IService<RptTnInvestEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnInvestEntity> selectListByNameCode(String name, String creditCode);

	RptTnInvestEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
