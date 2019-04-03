package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaApiLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-20 14:37:44
 */
public interface QichachaApiLogService extends IService<QichachaApiLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

