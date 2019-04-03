package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccSeriousViolationEntity;

import java.util.Map;

/**
 * 企查查-严重违法信息表
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:34:47
 */
public interface QccSeriousViolationService extends IService<QccSeriousViolationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 调用企查查接口获得严重违法信息
     * @param searchKey 关键字(公司名或keyNo)
     * @return
     */
    void getApiQccViolation(String searchKey);

    void updateDataStatusByEntName(String name,DataStatusEnum statusEnum);
}

