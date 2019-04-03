package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportAmountEntity;

import java.util.Map;

/**
 * tyc企业年报-企业资产状况
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
public interface RptTnReportAmountService extends IService<RptTnReportAmountEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	RptTnReportAmountEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

