package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnBasicInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 工商基本信息
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:23
 */
public interface RptTnBasicInfoService extends IService<RptTnBasicInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	int countByEnterpriseNameAndRegNo(String enterpriseName, String regNo);

	RptTnBasicInfoEntity selectByEnterpriseNameAndRegNo(String enterpriseName, String regNo);

	RptTnBasicInfoEntity selectListByNameCode(String name, String creditCode);

	Integer deleteByEnteprirseName(String name);

	RptTnBasicInfoEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

