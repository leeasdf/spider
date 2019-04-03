package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.SysExceptionLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-24 14:37:23
 */
public interface SysExceptionLogService extends IService<SysExceptionLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

