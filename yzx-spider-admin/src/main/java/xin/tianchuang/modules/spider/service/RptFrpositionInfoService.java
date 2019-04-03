package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptFrpositionInfoEntity;

/**
 * 信用麓谷-待定
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface RptFrpositionInfoService extends IService<RptFrpositionInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

