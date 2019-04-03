package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 信用中国-信用类型中间表(路由记录表)
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaCreditTypeRecordService extends IService<CreditchinaCreditTypeRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CreditchinaCreditTypeRecordEntity> selectByEntName(String entName);

    int deleteByEntName(String entName);
}

