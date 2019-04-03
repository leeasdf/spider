package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtLicenseEntity;

/**
 * 省发改委-环境行政许可(省环保厅)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:19
 */
public interface CsSfgwHbtLicenseService extends IService<CsSfgwHbtLicenseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

