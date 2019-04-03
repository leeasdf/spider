package xin.tianchuang.modules.externalApi.qichacha.dao;

import org.apache.ibatis.annotations.Param;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccCopyrightEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企查查API-软件著作权
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-19 17:47:48
 */
@Mapper
public interface QccCopyrightDao extends BaseMapper<QccCopyrightEntity> {

    void updateDataStatusByEntName(@Param("entName") String entName, @Param("dataStatus") Integer dataStatus);
	
}
