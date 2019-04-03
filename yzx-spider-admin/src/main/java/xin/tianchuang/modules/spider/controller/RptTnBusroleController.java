package xin.tianchuang.modules.spider.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.annotation.SysLog;

import xin.tianchuang.modules.spider.entity.RptTnBusroleEntity;
import xin.tianchuang.modules.spider.service.RptTnBusroleService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:38
 */
@RestController
@RequestMapping("spider/rpttnbusrole")
@Api("")
public class RptTnBusroleController {
	@Autowired
	private RptTnBusroleService rptTnBusroleService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnbusrole:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnBusroleService.queryPage(params);

		return R.ok().put("page", page);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnbusrole:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnBusroleEntity rptTnBusrole = rptTnBusroleService.selectById(id);
		return R.ok().put("rptTnBusrole", rptTnBusrole);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnbusrole:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnBusroleEntity rptTnBusrole) {
		rptTnBusroleService.insert(rptTnBusrole);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnbusrole:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnBusroleEntity rptTnBusrole) {
		rptTnBusroleService.updateById(rptTnBusrole);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnbusrole:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnBusroleService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
