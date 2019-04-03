package xin.tianchuang.modules.externalApi.qichacha.dao;

import org.apache.ibatis.annotations.Param;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTenderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企查查——企业招投标信息
 * 
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:29:53
 */
@Mapper
public interface QccTenderDao extends BaseMapper<QccTenderEntity> {

    void updateDataStatusByEntName(@Param("entName") String entName, @Param("dataStatus") Integer dataStatus);
}
