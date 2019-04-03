package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnAbnormalEntity;

/**
 * 经营异常信息
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:23
 */
public interface RptTnAbnormalService extends IService<RptTnAbnormalEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnAbnormalEntity> selectListByNameCode(String name, String creditCode);

	RptTnAbnormalEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

