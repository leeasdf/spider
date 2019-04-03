package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicPermissionInfoEntity;

import java.util.Map;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-行政许可【信用中国】
 *
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:54
 */
public interface QccBasicPermissionInfoService extends IService<QccBasicPermissionInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

