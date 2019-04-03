package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntLocalTaxCreditInfoEntity;

/**
 * 地方税务局税务评价表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface EntLocalTaxCreditInfoService extends IService<EntLocalTaxCreditInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

