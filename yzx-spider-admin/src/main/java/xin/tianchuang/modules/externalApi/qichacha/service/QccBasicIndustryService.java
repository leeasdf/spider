package xin.tianchuang.modules.externalApi.qichacha.service;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccBasicIndustryEntity;

import java.util.Map;

/**
 * 企查查接口数据-企业关键字精确获取详细信息(Full)-行业分类数据
 *
 * @author jiyang.hu
 * @email 
 * @date 2019-01-04 14:26:52
 */
public interface QccBasicIndustryService extends IService<QccBasicIndustryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

