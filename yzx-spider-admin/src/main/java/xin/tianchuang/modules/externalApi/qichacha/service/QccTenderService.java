package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTenderEntity;

import java.util.Map;

/**
 * 企查查——企业招投标信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:29:53
 */
public interface QccTenderService extends IService<QccTenderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 调用企查查接口获得企业招投标信息信息
     * @param searchKey 关键字（公司名、社会统一信用代码、注册号）
     * @return
     */
    void getApiQccTender(String searchKey);

    void updateDataStatusByEntName(String name,DataStatusEnum statusEnum);
}

