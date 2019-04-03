package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnProductEntity;

/**
 * 企业-产品信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:32:07
 */
public interface RptTnProductService extends IService<RptTnProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnProductEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

