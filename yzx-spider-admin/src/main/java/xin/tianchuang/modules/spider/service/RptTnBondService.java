package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnBondEntity;

/**
 * 企业-债券信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:32:08
 */
public interface RptTnBondService extends IService<RptTnBondEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnBondEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

