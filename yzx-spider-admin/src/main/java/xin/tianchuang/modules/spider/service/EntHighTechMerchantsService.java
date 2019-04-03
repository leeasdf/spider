package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechMerchantsEntity;

/**
 * 招商项目合同情况表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechMerchantsService extends IService<EntHighTechMerchantsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

