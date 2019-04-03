package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPenaltyEntity;

import java.util.Map;

/**
 * 信用中国-行政处罚
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaPubPenaltyService extends IService<CreditchinaPubPenaltyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int deleteByEntName(String entName);

    /**
     * 根据 处罚对象(企业名称)分页查询 行政处罚 企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByCfXdrMc(Map<String, Object> params);
}

