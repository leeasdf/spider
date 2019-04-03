package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriEnterpriseTaxOwingEntity;

/**
 * 省发改委-长沙地税-欠税公告信息表(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriEnterpriseTaxOwingService extends IService<OriEnterpriseTaxOwingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

