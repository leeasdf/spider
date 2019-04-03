package xin.tianchuang.modules.spider.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.spider.entity.TycPageRecordEntity;

/**
 * 天眼查分页记录表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 10:14:18
 */
@Mapper
public interface TycPageRecordDao extends BaseMapper<TycPageRecordEntity> {
	
}
