package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnReportSocialEntity;

import java.util.Map;

/**
 * tyc企业年报-社保信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
public interface RptTnReportSocialService extends IService<RptTnReportSocialEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	RptTnReportSocialEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

