package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnLicensingEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc企业行政许可[工商局]信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:47
 */
public interface RptTnLicensingService extends IService<RptTnLicensingEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	List<RptTnLicensingEntity> selectListByNameCode(String name, String creditCode);

	RptTnLicensingEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);

}

