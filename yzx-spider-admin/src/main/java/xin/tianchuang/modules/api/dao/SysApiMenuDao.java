package xin.tianchuang.modules.api.dao;

import java.util.List;

import xin.tianchuang.modules.api.entity.SysApiMenuEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * api菜单表
 * 
 * @author hui.deng
 * @email
 * @date 2018-10-17 16:25:41
 */
@Mapper
public interface SysApiMenuDao extends BaseMapper<SysApiMenuEntity> {

	SysApiMenuEntity queryApiMenuByApiUrl(String apiUrl);

	Integer deleteBatchByNotApiUrls(@Param("apiUrlList") List<String> checkApis);

	List<SysApiMenuEntity> queryApiMenuByAppId(@Param("appId")Long appId);
}
