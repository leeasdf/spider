package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportInvestEntity;

import java.util.Map;

/**
 * tyc企业年报-对外投资信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
public interface RptTnReportInvestService extends IService<RptTnReportInvestEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	RptTnReportInvestEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

