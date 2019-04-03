package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechBlackInfoEntity;

/**
 * 失信黑榜
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechBlackInfoService extends IService<EntHighTechBlackInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

