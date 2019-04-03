package xin.tianchuang.modules.api.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.toolkit.IdWorker;

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;
import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.modules.api.service.SysUserApiTokenService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.sys.service.SysUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户平台token表
 *
 * @author hui.deng
 * @email
 * @date 2018-10-16 16:44:35
 */
@RestController
@RequestMapping("api/sysuserapitoken")
@Api(value = "", description = "")
public class SysUserApiTokenController {
	@Autowired
	private SysUserApiTokenService sysUserApiTokenService;
	@Autowired
	private SysAppApiService sysAppApiService;

	@InitBinder
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		//initDataBinder(request, binder);
	}


	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:sysuserapitoken:list")
	@ApiOperation(value = "", notes = "")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysUserApiTokenService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("api:sysuserapitoken:info")
	@ApiOperation(value = "", notes = "")
	public R info(@PathVariable("userId") Long userId) {
		SysUserApiTokenEntity sysUserApiToken = sysUserApiTokenService.selectById(userId);
 		if (sysUserApiToken == null){
 			sysUserApiToken = new SysUserApiTokenEntity();
 			sysUserApiToken.setToken(UUID.randomUUID().toString().replaceAll("-",""));
		}
		return R.ok().put("sysUserApiToken", sysUserApiToken);
	}


	/**
	 * 保存
	 */
	@SysLog("保存token信息")
	@RequestMapping("/save")
	@RequiresPermissions("api:sysuserapitoken:save")
	@ApiOperation(value = "", notes = "")
	public R save(@RequestBody SysUserApiTokenEntity sysUserApiToken) {
		String appId = IdWorker.get32UUID();
		String token = IdWorker.get32UUID();
		sysUserApiToken.setAppId(appId);
		sysUserApiToken.setToken(token);

		sysUserApiTokenService.insert(sysUserApiToken);
		return R.ok().put("appId", appId).put("token", token);
	}

	/**
	 * 修改
	 */
	@SysLog("修改app信息")
	@RequestMapping("/update")
	@RequiresPermissions("api:sysuserapitoken:update")
	@ApiOperation(value = "", notes = "")
	public R update(@RequestBody SysUserApiTokenEntity sysUserApiToken) {
		SysUserApiTokenEntity app = sysUserApiTokenService.selectById(sysUserApiToken.getUserId());
		if (app==null){
			String appId = sysUserApiToken.getAppId()==null ? IdWorker.get32UUID() :sysUserApiToken.getAppId();
			String token = IdWorker.get32UUID();
			sysUserApiToken.setAppId(appId);
			sysUserApiToken.setToken(token);
			sysUserApiTokenService.insert(sysUserApiToken);
			return R.ok().put("appId", appId).put("token", token);
		}
		sysUserApiTokenService.updateById(sysUserApiToken);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除app信息")
	@RequestMapping("/delete")
	@RequiresPermissions("api:sysuserapitoken:delete")
	@ApiOperation(value = "", notes = "")
	public R delete(@RequestBody Long[] userIds) {
		sysUserApiTokenService.deleteBatchIds(Arrays.asList(userIds));

		return R.ok();
	}

}
