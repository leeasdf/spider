package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.RptLegalbadInfoEntity;

/**
 * 信用麓谷-法人不良信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:17
 */
public interface RptLegalbadInfoService extends IService<RptLegalbadInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

