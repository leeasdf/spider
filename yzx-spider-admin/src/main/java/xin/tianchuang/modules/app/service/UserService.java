package xin.tianchuang.modules.app.service;

import java.util.List;

import xin.tianchuang.modules.app.entity.UserEntity;
import xin.tianchuang.modules.app.form.LoginForm;
import xin.tianchuang.modules.app.form.RegisterForm;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * 用户
 * 
 * @author hui.deng
 * 
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * 
	 * @param form
	 *            登录表单
	 * @return 返回用户ID
	 */
	long login(LoginForm form);

	/**
	 * 用户注册
	 * 
	 * @param form
	 */
	void register(RegisterForm form);

	List<UserEntity> selectUserPage(Page<UserEntity> page, Integer state);
}
