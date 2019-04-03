package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriEnterpriseBusinessBaseInfoEntity;

/**
 * 省发改委-长沙工商-企业基础信息(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriEnterpriseBusinessBaseInfoService extends IService<OriEnterpriseBusinessBaseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

