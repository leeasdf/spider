package xin.tianchuang.modules.api.dao;

import xin.tianchuang.modules.api.entity.SysAppApiEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 应用接口对照表
 * 
 * @author hui.deng
 * @email
 * @date 2018-10-17 16:25:42
 */
@Mapper
public interface SysAppApiDao extends BaseMapper<SysAppApiEntity> {

	SysAppApiEntity queryInfoByApiIdAndAppId(@Param("appId") String appId, @Param("apiId") Integer apiId);

	/**
	 * 根据appID数组，批量删除
	 */
	int deleteBatch(String[] appIds);

}
