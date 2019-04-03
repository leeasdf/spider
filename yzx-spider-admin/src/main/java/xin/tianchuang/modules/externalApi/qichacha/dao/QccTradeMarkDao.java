package xin.tianchuang.modules.externalApi.qichacha.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTradeMarkEntity;

/**
 * 企查查-商标查询表
 * 
 * @author hui.deng
 * @email 
 * @date 2018-12-21 14:29:10
 */
@Mapper
public interface QccTradeMarkDao extends BaseMapper<QccTradeMarkEntity> {

    @Update("update qichacha_trade_mark set data_status=#{2} where ent_name=#{1}")
    Integer deleteByEntName(String name, int key);
}
