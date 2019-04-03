package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxInformationEntity;

/**
 * 省发改委-欠缴税信息(省国税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwTaxInformationService extends IService<CsSfgwTaxInformationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

