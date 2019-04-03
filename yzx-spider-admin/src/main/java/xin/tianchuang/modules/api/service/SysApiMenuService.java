package xin.tianchuang.modules.api.service;

import com.baomidou.mybatisplus.service.IService;

import org.apache.ibatis.annotations.Param;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.entity.SysApiMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * api菜单表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 16:25:41
 */
public interface SysApiMenuService extends IService<SysApiMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

	SysApiMenuEntity queryApiMenuByApiUrl(String urlPrefix);

	Integer deleteBatchByNotApiUrls(List<String> checkApis);

	List<SysApiMenuEntity> queryApiMenuByAppId(Long appId);
}

