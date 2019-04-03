package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptFrinvInfoEntity;

/**
 * 信用麓谷-企业对外投资
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptFrinvInfoService extends IService<RptFrinvInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

