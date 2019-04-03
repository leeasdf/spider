package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwAicContactEntity;

/**
 * 省发改委-联络员信息(省工商局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwAicContactService extends IService<CsSfgwAicContactEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

