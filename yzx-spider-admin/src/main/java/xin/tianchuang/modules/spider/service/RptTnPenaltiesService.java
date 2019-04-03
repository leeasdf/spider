package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnPenaltiesEntity;

/**
 * 行政处罚信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:17
 */
public interface RptTnPenaltiesService extends IService<RptTnPenaltiesEntity> {

	PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	List<RptTnPenaltiesEntity> selectListByNameCode(String name, String creditCode);

	RptTnPenaltiesEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}
