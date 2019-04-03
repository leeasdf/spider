package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptCblackInfoEntity;

/**
 * 信用麓谷-失信黑名单信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptCblackInfoService extends IService<RptCblackInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

