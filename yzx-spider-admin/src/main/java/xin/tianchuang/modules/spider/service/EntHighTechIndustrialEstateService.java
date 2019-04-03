package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntHighTechIndustrialEstateEntity;

/**
 * 工业地产注入项目情况表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:24
 */
public interface EntHighTechIndustrialEstateService extends IService<EntHighTechIndustrialEstateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

