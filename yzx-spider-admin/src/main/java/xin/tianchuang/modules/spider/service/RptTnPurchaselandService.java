package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnPurchaselandEntity;

/**
 * 企业-购地信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:32:08
 */
public interface RptTnPurchaselandService extends IService<RptTnPurchaselandEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnPurchaselandEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

