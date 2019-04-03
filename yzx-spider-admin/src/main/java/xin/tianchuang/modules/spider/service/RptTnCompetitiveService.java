package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnCompetitiveEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc企业-竞品信息
 *
 * @author hui.deng
 * @email
 * @date 2018-12-04 14:24:45
 */
public interface RptTnCompetitiveService extends IService<RptTnCompetitiveEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnCompetitiveEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
