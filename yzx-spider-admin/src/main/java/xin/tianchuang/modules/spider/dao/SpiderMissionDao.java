package xin.tianchuang.modules.spider.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;

/**
 * 爬虫任务
 * 
 * @author hui.deng
 * @email 
 * @date 2018-10-17 17:04:27
 */
@Mapper
public interface SpiderMissionDao extends BaseMapper<SpiderMissionEntity> {
	
}
