package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusPenaltyEntity;

import java.util.Map;

/**
 * 信用中国-重点关注名单-证监会
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
public interface CreditchinaFocusPenaltyService extends IService<CreditchinaFocusPenaltyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据 处罚对象名称(企业名称) 分页查询 重点关注名单-证监会 信息 名称全匹配
     * @param params
     * @return
     */
    PageUtils queryPageByPunishmentObject(Map<String, Object> params);
}

