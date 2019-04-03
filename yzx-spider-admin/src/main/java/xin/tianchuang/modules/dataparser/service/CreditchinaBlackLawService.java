package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBlackLawEntity;

import java.util.Map;

/**
 * 信用中国-黑名单-最高法
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
public interface CreditchinaBlackLawService extends IService<CreditchinaBlackLawEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据 失信被执行人名称(企业名称)分页查询 黑名单-最高法 企业名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByDishonestName(Map<String, Object> params);
}

