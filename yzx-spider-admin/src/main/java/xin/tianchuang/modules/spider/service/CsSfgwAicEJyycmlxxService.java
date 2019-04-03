package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwAicEJyycmlxxEntity;

/**
 * 省发改委-企业经营异常详细信息(省工商局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwAicEJyycmlxxService extends IService<CsSfgwAicEJyycmlxxEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

