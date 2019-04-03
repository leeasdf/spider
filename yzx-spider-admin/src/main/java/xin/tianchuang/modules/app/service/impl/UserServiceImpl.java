package xin.tianchuang.modules.app.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.validator.Assert;
import xin.tianchuang.modules.app.dao.UserDao;
import xin.tianchuang.modules.app.entity.UserEntity;
import xin.tianchuang.modules.app.form.LoginForm;
import xin.tianchuang.modules.app.form.RegisterForm;
import xin.tianchuang.modules.app.service.UserService;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		// 密码错误
		if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
			throw new SpiderException("手机号或密码错误");
		}

		return user.getUserId();
	}

	@Override
	public void register(RegisterForm form) {
		UserEntity user = new UserEntity();
		user.setMobile(form.getMobile());
		user.setUsername(form.getMobile());
		user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		baseMapper.insert(user);
	}

	@Override
	public List<UserEntity> selectUserPage(Page<UserEntity> page, Integer state) {
		// 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
		// page.setOptimizeCountSql(false);
		// 不查询总记录数
		// page.setSearchCount(false);
		// 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
		return baseMapper.selectUserList(page);
	}
}
