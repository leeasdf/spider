package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHunanStateTaxInfoEntity;

/**
 * 湖南省国家税务局纳税信用评价表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface EntHunanStateTaxInfoService extends IService<EntHunanStateTaxInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

