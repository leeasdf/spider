package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.HntaxOweTaxInfoEntity;

import java.util.Map;

/**
 *  湖南省税务局-欠税公告
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-12 17:41:23
 */
public interface HntaxOweTaxInfoService extends IService<HntaxOweTaxInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

	HntaxOweTaxInfoEntity selectByOne(HntaxOweTaxInfoEntity entity);
}

