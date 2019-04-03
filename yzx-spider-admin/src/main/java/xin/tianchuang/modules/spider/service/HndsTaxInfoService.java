package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HndsTaxInfoEntity;

import java.util.Map;

/**
 * 湖南省地方税务局-税务登记信息信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-25 09:04:52
 */
public interface HndsTaxInfoService extends IService<HndsTaxInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	HndsTaxInfoEntity selectByOne(String taxNo, String taxper, String legalName, String authority, String taxStatus);
}

