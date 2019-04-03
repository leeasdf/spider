package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriNationalTaxBaseEntity;

/**
 * 国税基础信息(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriNationalTaxBaseService extends IService<OriNationalTaxBaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

