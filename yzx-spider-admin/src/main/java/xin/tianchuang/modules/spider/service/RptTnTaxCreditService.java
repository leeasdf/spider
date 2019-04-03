package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnTaxCreditEntity;

/**
 * 税务评级信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:18
 */
public interface RptTnTaxCreditService extends IService<RptTnTaxCreditEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnTaxCreditEntity> selectListByNameCode(String name, String creditCode);

	RptTnTaxCreditEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

