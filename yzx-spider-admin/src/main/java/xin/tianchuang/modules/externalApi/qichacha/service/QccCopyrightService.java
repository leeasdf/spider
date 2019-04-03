package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import io.swagger.models.auth.In;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccCopyrightEntity;
import xin.tianchuang.modules.externalApi.qichacha.meta.QichachaRq;

import java.util.List;
import java.util.Map;

/**
 * 企查查API-软件著作权
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-19 17:47:48
 */
public interface QccCopyrightService extends IService<QccCopyrightEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 调用企查查接口获得著作权信息
     * @param searchKey 关键字(公司名或keyNo)
     * @return
     */
    void getApiQccCopyright(String searchKey);

    void updateDataStatusByEntName(String name,DataStatusEnum statusEnum);
}

