package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptTrademarkInfoEntity;

/**
 * 信用麓谷-商标信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:18
 */
public interface RptTrademarkInfoService extends IService<RptTrademarkInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

