package xin.tianchuang.modules.spider.dao;

import org.apache.ibatis.annotations.Select;
import xin.tianchuang.modules.spider.entity.SpiderRawDataEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 从页面爬取的数据，内容格式可能是html、js、json
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-29 16:51:37
 */
@Mapper
public interface SpiderRawDataDao extends BaseMapper<SpiderRawDataEntity> {

    @Select("select * from spider_raw_data where type=#{1} order by `cursor_index` desc limit 1")
    SpiderRawDataEntity selectLatestCreditHunanByType(Integer type);
    @Select("select * from spider_raw_data where type=#{1} order by cast(cursor_index as SIGNED) desc limit 1")
    SpiderRawDataEntity selectLatestCreditChinaData(Integer type);
}
