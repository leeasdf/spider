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

import xin.tianchuang.modules.spider.entity.RptTnEntPersonCmpanyEntity;
import xin.tianchuang.modules.spider.service.RptTnEntPersonCmpanyService;
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
@RequestMapping("spider/rpttnentpersoncmpany")
@Api("")
public class RptTnEntPersonCmpanyController {
	@Autowired
	private RptTnEntPersonCmpanyService rptTnEntPersonCmpanyService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnentpersoncmpany:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnEntPersonCmpanyService.queryPage(params);

		return R.ok().put("page", page);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnentpersoncmpany:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnEntPersonCmpanyEntity rptTnEntPersonCmpany = rptTnEntPersonCmpanyService.selectById(id);

		return R.ok().put("rptTnEntPersonCmpany", rptTnEntPersonCmpany);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnentpersoncmpany:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnEntPersonCmpanyEntity rptTnEntPersonCmpany) {
		rptTnEntPersonCmpanyService.insert(rptTnEntPersonCmpany);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnentpersoncmpany:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnEntPersonCmpanyEntity rptTnEntPersonCmpany) {
		rptTnEntPersonCmpanyService.updateById(rptTnEntPersonCmpany);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnentpersoncmpany:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnEntPersonCmpanyService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
