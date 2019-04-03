package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptLitigationInfoEntity;

/**
 * 信用麓谷-企业涉诉信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface RptLitigationInfoService extends IService<RptLitigationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

