package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicMPledgeEntity;

import java.util.Map;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-动产抵押
 *
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:53
 */
public interface QccBasicMPledgeService extends IService<QccBasicMPledgeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

