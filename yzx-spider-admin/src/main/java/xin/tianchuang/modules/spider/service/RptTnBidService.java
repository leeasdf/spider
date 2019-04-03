package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnBidEntity;

/**
 * 招投标信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:14
 */
public interface RptTnBidService extends IService<RptTnBidEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnBidEntity> selectListByNameCode(String name, String creditCode);

	RptTnBidEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
