package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnDishonestEntity;

/**
 * 失信人信息
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:23
 */
public interface RptTnDishonestService extends IService<RptTnDishonestEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnDishonestEntity> selectListByNameCode(String name, String creditCode);

	RptTnDishonestEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

