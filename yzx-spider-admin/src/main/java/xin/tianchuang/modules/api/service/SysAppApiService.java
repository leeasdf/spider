package xin.tianchuang.modules.api.service;

import com.baomidou.mybatisplus.service.IService;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;

import java.util.List;
import java.util.Map;

/**
 * 应用接口对照表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 16:25:42
 */
public interface SysAppApiService extends IService<SysAppApiEntity> {

    PageUtils queryPage(Map<String, Object> params);

	SysAppApiEntity queryInfoByApiIdAndAppId(String appId, Integer apiId);

    void saveOrUpdate(String appId, List<Long> apiIdList);

    int deleteBatch(String[] appIds);
}

