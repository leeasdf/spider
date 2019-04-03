package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnWorksRightEntity;

/**
 * 作品著作权信息
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 15:43:22
 */
public interface RptTnWorksRightService extends IService<RptTnWorksRightEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnWorksRightEntity> selectListByNameCode(String name, String creditCode);

	RptTnWorksRightEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

