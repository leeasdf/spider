package xin.tianchuang.modules.externalApi.qichacha.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import xin.tianchuang.modules.externalApi.qichacha.entity.QichachaDataPatentEntity;

/**
 * 企查查接口数据-专利
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-20 16:46:43
 */
@Mapper
public interface QichachaDataPatentDao extends BaseMapper<QichachaDataPatentEntity> {

    @Update("update qichacha_data_patent set data_status=#{key} where ent_name=#{name}")
    Integer deleteByEntName(@Param("name") String name,@Param("key") Integer key);
}
