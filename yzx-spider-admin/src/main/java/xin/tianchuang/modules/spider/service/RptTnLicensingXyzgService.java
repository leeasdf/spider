package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnLicensingXyzgEntity;

/**
 * 企业-行政处罚[信用中国]
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:44:11
 */
public interface RptTnLicensingXyzgService extends IService<RptTnLicensingXyzgEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnLicensingXyzgEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

