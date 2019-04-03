package xin.tianchuang.modules.spider.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.TycPageRecordEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 天眼查分页记录表
 *
 * @author hui.deng
 * 
 * @date 2018-09-28 16:23:43
 */
public interface TycPageRecordService extends IService<TycPageRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    TycPageRecordEntity selectByEnterpriseNameAndDataType(String name, int dataType);
}

