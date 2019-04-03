package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaDataPatentEntity;

import java.util.Map;

/**
 * 企查查接口数据-专利
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-20 16:46:43
 */
public interface QichachaDataPatentService extends IService<QichachaDataPatentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void getApiQccPatent(String name);

    void updateDataStatusByEntName(String name, DataStatusEnum unActive);
}

