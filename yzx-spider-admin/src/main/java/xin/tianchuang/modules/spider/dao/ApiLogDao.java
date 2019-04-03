package xin.tianchuang.modules.spider.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.spider.entity.ApiLogEntity;

/**
 * API日志表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
@Mapper
public interface ApiLogDao extends BaseMapper<ApiLogEntity> {
	
}
