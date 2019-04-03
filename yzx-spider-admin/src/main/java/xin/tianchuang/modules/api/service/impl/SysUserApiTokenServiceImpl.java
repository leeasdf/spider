package xin.tianchuang.modules.api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import xin.tianchuang.common.constant.Constant;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.api.dao.SysUserApiTokenDao;
import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.modules.api.service.SysUserApiTokenService;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.modules.sys.entity.SysRoleEntity;
import xin.tianchuang.modules.sys.entity.SysUserEntity;
import xin.tianchuang.modules.sys.service.SysUserService;

@Service("sysUserApiTokenService")
public class SysUserApiTokenServiceImpl extends ServiceImpl<SysUserApiTokenDao, SysUserApiTokenEntity> implements SysUserApiTokenService {

	@Autowired
	private SysAppApiService sysAppApiService;
	@Autowired
	private SysUserService sysUserService;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysUserApiTokenEntity> page = this.selectPage(new Query<SysUserApiTokenEntity>(params).getPage(), new EntityWrapper<SysUserApiTokenEntity>());
		for (SysUserApiTokenEntity sysUserApiTokenEntity : page.getRecords()) {
			SysUserEntity userEntity = sysUserService.selectById(sysUserApiTokenEntity.getUserId());
			sysUserApiTokenEntity.setUsername(userEntity.getUsername());
		}
		return new PageUtils(page);
	}

	@Override
	public SysUserApiTokenEntity getTokenByAppId(String appId) {
		return baseMapper.getTokenByAppId(appId);
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUserApiTokenEntity entity) {
		this.insert(entity);
		sysAppApiService.saveOrUpdate(entity.getAppId(), entity.getApiIdList());

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserApiTokenEntity entity) {
		this.updateById(entity);
		sysAppApiService.saveOrUpdate(entity.getAppId(), entity.getApiIdList());

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(String[] appIds) {
		//删除应用
		this.deleteBatchIds(Arrays.asList(appIds));

		//删除应用与api关联
		sysAppApiService.deleteBatch(appIds);

		//todo 删除用户与应用关联


	}

}
