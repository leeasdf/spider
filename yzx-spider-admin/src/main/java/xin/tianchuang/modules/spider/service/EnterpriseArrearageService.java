package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EnterpriseArrearageEntity;

/**
 * 企业-欠款信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface EnterpriseArrearageService extends IService<EnterpriseArrearageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

