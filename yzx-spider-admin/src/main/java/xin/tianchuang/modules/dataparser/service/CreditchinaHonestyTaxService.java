package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaHonestyTaxEntity;

import java.util.Map;

/**
 * 信用中国-守信红名单
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaHonestyTaxService extends IService<CreditchinaHonestyTaxEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据 纳税人名称(企业名称)分页查询 守信红名单 企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByTaxName(Map<String, Object> params);
}

