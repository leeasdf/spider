package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.ApiLogEntity;

/**
 * API日志表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
public interface ApiLogService extends IService<ApiLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

