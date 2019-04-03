package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportShareholderEntity;

import java.util.Map;

/**
 * tyc企业年报-股东及出资信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
public interface RptTnReportShareholderService extends IService<RptTnReportShareholderEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnReportShareholderEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

