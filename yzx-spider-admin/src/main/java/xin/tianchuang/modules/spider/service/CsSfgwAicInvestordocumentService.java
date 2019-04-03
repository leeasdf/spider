package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwAicInvestordocumentEntity;

/**
 * 省发改委-企业股东信息(省工商局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwAicInvestordocumentService extends IService<CsSfgwAicInvestordocumentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

