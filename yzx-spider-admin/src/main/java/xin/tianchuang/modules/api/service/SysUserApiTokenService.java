package xin.tianchuang.modules.api.service;

import java.util.Map;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;

import com.baomidou.mybatisplus.service.IService;
import xin.tianchuang.modules.sys.entity.SysRoleEntity;

/**
 * 用户平台token表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-16 16:44:35
 */
public interface SysUserApiTokenService extends IService<SysUserApiTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
	/**
	 * 根据appid查询token
	 * 
	 * @param appId
	 * @return
	 */
	SysUserApiTokenEntity getTokenByAppId(String appId);

	void save(SysUserApiTokenEntity entity);

	void update(SysUserApiTokenEntity entity);

	void deleteBatch(String[] appIds);
}

