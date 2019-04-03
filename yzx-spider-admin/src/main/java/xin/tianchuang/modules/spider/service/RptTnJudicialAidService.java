package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnJudicialAidEntity;

/**
 * 企业-司法协助信息
 *
 * @author hui.deng
 * @email ${email}
 * @date 2018-07-31 17:32:08
 */
public interface RptTnJudicialAidService extends IService<RptTnJudicialAidEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnJudicialAidEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

