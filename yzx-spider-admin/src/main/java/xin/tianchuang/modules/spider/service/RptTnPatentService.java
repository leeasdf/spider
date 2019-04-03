package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnPatentEntity;

/**
 * 专利信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-05-21 16:51:18
 */
public interface RptTnPatentService extends IService<RptTnPatentEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String entName);

	List<RptTnPatentEntity> selectListByNameCode(String name, String creditCode);

	RptTnPatentEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

