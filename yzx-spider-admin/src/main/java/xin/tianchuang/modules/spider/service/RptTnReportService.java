package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportEntity;

import java.util.Map;

/**
 * tyc企业-年报信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
public interface RptTnReportService extends IService<RptTnReportEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnReportEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

