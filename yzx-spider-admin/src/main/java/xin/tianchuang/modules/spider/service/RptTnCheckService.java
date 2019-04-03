package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnCheckEntity;

/**
 * 抽查检查信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:16
 */
public interface RptTnCheckService extends IService<RptTnCheckEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	List<RptTnCheckEntity> selectListByNameCode(String name, String creditCode);

	RptTnCheckEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
