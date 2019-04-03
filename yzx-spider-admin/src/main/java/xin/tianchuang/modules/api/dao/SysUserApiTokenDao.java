package xin.tianchuang.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 用户平台token表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-16 16:44:35
 */
@Mapper
public interface SysUserApiTokenDao extends BaseMapper<SysUserApiTokenEntity> {

	SysUserApiTokenEntity getTokenByAppId(String appId);
	
}
