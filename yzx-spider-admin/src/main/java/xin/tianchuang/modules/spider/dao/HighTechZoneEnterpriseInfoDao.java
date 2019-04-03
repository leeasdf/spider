package xin.tianchuang.modules.spider.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;

/**
 * 企业基础信息表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-09-07 11:17:22
 */
@Mapper
public interface HighTechZoneEnterpriseInfoDao extends BaseMapper<HighTechZoneEnterpriseInfoEntity> {

    @Select("select max(id) from high_tech_zone_enterprise_info")
    long selectMaxId();
}
