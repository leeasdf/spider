package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.EntIndustrialOutputEntity;

/**
 * 企业-工业产值信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:16
 */
public interface EntIndustrialOutputService extends IService<EntIndustrialOutputEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

