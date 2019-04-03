package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptPlitigationInfoEntity;

/**
 * 信用麓谷-企业不良信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface RptPlitigationInfoService extends IService<RptPlitigationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

