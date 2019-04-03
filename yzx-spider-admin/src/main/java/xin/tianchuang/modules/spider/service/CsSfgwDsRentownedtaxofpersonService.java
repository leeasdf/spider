package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.CsSfgwDsRentownedtaxofpersonEntity;

/**
 * 省发改委-企业欠税公告信息(省地税局)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface CsSfgwDsRentownedtaxofpersonService extends IService<CsSfgwDsRentownedtaxofpersonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

