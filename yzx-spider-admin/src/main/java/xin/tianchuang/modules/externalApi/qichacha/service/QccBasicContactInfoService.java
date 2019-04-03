package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicContactInfoEntity;

import java.util.Map;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-联系信息
 *
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
public interface QccBasicContactInfoService extends IService<QccBasicContactInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

