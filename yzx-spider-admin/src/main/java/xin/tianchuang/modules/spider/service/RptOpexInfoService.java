package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptOpexInfoEntity;

/**
 * 信用麓谷-企业经营异常
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface RptOpexInfoService extends IService<RptOpexInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

