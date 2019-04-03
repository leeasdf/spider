package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnPersonEntity;

/**
 * 主要人员
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:22
 */
public interface RptTnPersonService extends IService<RptTnPersonEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnPersonEntity> selectListByNameCode(String name, String creditCode);

	RptTnPersonEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

