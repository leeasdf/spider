package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeEntity;
import xin.tianchuang.modules.dataparser.enums.CreditChinaCreditTypeEnum;

import java.util.List;
import java.util.Map;

/**
 * 信用中国-信用类型中间表(路由表)
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaCreditTypeService extends IService<CreditchinaCreditTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取路由表的信息
     * @return
     */
    List<CreditchinaCreditTypeEntity> getAllCreditTypeEntity();

    /**
     * 查询路由定义表中某一类有所有的配置信息
     * @param creditType
     * @return
     */
    List<CreditchinaCreditTypeEntity> getByCreditType(CreditChinaCreditTypeEnum creditType);
}

