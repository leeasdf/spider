package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTnPunishCreditchinaEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * tyc行政处罚[信用中国]
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-03 17:46:29
 */
public interface RptTnPunishCreditchinaService extends IService<RptTnPunishCreditchinaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer deleteByEnteprirseName(String name);

	RptTnPunishCreditchinaEntity selectByEnterpriseId(Long enterpriseId);

	Integer selectCountByEnterpriseId(Long enterpriseId);
}

