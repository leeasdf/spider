package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTradeMarkEntity;

import java.util.Map;

/**
 * 企查查-商标查询表
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-21 14:29:10
 */
public interface QccTradeMarkService extends IService<QccTradeMarkEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 调用企查查接口获得商标信息
     * @param searchKey 关键字(公司名或keyNo)
     * @return
     */
    void getApiQccTradeMark(String searchKey);

    void updateDataStatusByEntName(String name,DataStatusEnum statusEnum);

}

