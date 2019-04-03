package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportWebsiteEntity;

import java.util.Map;

/**
 * tyc企业年报-网站或网店信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
public interface RptTnReportWebsiteService extends IService<RptTnReportWebsiteEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	RptTnReportWebsiteEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

