package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechVerifyInfoEntity;

/**
 * 企业-资质认定
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
public interface EntHighTechVerifyInfoService extends IService<EntHighTechVerifyInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

