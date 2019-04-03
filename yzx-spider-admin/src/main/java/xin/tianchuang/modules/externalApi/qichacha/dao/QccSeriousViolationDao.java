package xin.tianchuang.modules.externalApi.qichacha.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccSeriousViolationEntity;

/**
 * 企查查-严重违法信息表
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:34:47
 */
@Mapper
public interface QccSeriousViolationDao extends BaseMapper<QccSeriousViolationEntity> {

    @Update("update qcc_serious_violation set data_status=#{2} where ent_name=#{1}")
    Integer deleteByEntName(String name, int key);
}
