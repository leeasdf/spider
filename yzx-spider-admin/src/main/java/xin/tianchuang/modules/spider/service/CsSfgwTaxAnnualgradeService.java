package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxAnnualgradeEntity;

/**
 * 省发改委-年度纳税信用A级纳税人名单(省国税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwTaxAnnualgradeService extends IService<CsSfgwTaxAnnualgradeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

