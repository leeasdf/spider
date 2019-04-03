package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechLandLedgerEntity;

/**
 * 国土发证台账情况表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechLandLedgerService extends IService<EntHighTechLandLedgerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

