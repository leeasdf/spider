package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwDsRentcreditaEntity;

/**
 * 省发改委-纳税信用A级纳税人信息(省地税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface CsSfgwDsRentcreditaService extends IService<CsSfgwDsRentcreditaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

