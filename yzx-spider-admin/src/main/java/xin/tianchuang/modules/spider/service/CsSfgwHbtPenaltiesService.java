package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtPenaltiesEntity;

/**
 * 省发改委-环境行政处罚(省环保厅)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwHbtPenaltiesService extends IService<CsSfgwHbtPenaltiesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

