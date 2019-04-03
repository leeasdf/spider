package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnMortgageEntity;

/**
 * 企业-动产抵押信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:32:08
 */
public interface RptTnMortgageService extends IService<RptTnMortgageEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnMortgageEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

