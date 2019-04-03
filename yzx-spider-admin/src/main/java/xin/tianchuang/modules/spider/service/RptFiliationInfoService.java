package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptFiliationInfoEntity;

/**
 * 信用麓谷-分支机构
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptFiliationInfoService extends IService<RptFiliationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

