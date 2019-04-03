package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriEnterpriseOperatingExceptionEntity;

/**
 * 省发改委-长沙工商-企业经营异常详细信息(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriEnterpriseOperatingExceptionService extends IService<OriEnterpriseOperatingExceptionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

