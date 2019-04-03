package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechInfoEntity;

/**
 * 湖南高新企业情况表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechInfoService extends IService<EntHighTechInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

