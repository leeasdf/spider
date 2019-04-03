package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxTaxofnopayedEntity;

/**
 * 省发改委-纳税企业欠税信息(省国税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwTaxTaxofnopayedService extends IService<CsSfgwTaxTaxofnopayedEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

