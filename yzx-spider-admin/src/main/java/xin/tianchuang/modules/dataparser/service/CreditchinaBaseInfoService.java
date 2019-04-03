package xin.tianchuang.modules.dataparser.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;

import java.util.Map;

/**
 * 信用中国-基本信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
public interface CreditchinaBaseInfoService extends IService<CreditchinaBaseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CreditchinaBaseInfoEntity getByNameOrCreditCode(String name, String creditCode);

    int deleteByEntName(String entName);
}

