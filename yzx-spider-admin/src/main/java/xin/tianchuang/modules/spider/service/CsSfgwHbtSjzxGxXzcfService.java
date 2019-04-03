package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtSjzxGxXzcfEntity;

/**
 * 省发改委-企业行政处罚信息(省环保厅)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwHbtSjzxGxXzcfService extends IService<CsSfgwHbtSjzxGxXzcfEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

