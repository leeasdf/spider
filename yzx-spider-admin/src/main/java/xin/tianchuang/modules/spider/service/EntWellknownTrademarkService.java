package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntWellknownTrademarkEntity;

/**
 * 企业驰名商标信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface EntWellknownTrademarkService extends IService<EntWellknownTrademarkEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

