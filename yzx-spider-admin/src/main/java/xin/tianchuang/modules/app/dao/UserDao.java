
package xin.tianchuang.modules.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import xin.tianchuang.modules.app.entity.UserEntity;
import xin.tianchuang.modules.sys.entity.SysUserEntity;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 用户
 * 
 * @author hui.deng
 * 
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

	List<UserEntity> selectUserList(Page<UserEntity> page);

}
