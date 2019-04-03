package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnEquityEntity;

/**
 * 股权质押信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-25 13:53:37
 */
public interface RptTnEquityService extends IService<RptTnEquityEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnEquityEntity> selectListByNameCode(String name, String creditCode);

	RptTnEquityEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

