package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnJudicialSaleEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc企业-司法拍卖信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 10:17:48
 */
public interface RptTnJudicialSaleService extends IService<RptTnJudicialSaleEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer deleteByEnteprirseName(String name);

	RptTnJudicialSaleEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

