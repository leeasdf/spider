package xin.tianchuang.modules.spider.service;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 企业基础信息表
 *
 * @author hui.deng
 * @email 
 * @date 2018-08-28 15:28:25
 */
public interface HighTechZoneEnterpriseInfoService extends IService<HighTechZoneEnterpriseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据省份、城市和状态来查询列表信息
     * @param fetch
     * @param status
     * @param province
     * @param city
     * @return
     */
    List<HighTechZoneEnterpriseInfoEntity> querEnterpriseListByCondition(Integer fetch, Integer status, String province, String city, String remark, Boolean isAsc);

	HighTechZoneEnterpriseInfoEntity selectByEnterpriseName(String enterpriseName);

	HighTechZoneEnterpriseInfoEntity selectByNameCode(String enterpriseName, String creditCode);

	PageUtils queryMatchPage(Map<String, Object> params);

    long selectMaxId();

}

