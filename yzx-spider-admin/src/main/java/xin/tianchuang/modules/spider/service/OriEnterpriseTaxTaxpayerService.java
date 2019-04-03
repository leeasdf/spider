package xin.tianchuang.modules.spider.service;

import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.spider.entity.OriEnterpriseTaxTaxpayerEntity;

/**
 * 省发改委-长沙地税-纳税人信息表(导入)
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:23
 */
public interface OriEnterpriseTaxTaxpayerService extends IService<OriEnterpriseTaxTaxpayerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

