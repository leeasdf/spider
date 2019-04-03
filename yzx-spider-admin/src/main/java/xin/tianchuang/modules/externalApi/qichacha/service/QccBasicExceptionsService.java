package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicExceptionsEntity;

import java.util.Map;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-经营异常
 *
 * @author jiyang.hu
 * @email 
 * @date 2019-01-15 15:26:44
 */
public interface QccBasicExceptionsService extends IService<QccBasicExceptionsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

