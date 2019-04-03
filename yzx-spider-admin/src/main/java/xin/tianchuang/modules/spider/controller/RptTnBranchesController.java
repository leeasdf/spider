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

import xin.tianchuang.modules.spider.entity.RptTnBranchesEntity;
import xin.tianchuang.modules.spider.service.RptTnBranchesService;
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
@RequestMapping("spider/rpttnbranches")
@Api("")
public class RptTnBranchesController {
	@Autowired
	private RptTnBranchesService rptTnBranchesService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnbranches:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnBranchesService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnbranches:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnBranchesEntity rptTnBranches = rptTnBranchesService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnBranches", rptTnBranches);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnbranches:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnBranchesEntity rptTnBranches = rptTnBranchesService.selectById(id);

		return R.ok().put("rptTnBranches", rptTnBranches);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnbranches:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnBranchesEntity rptTnBranches) {
		rptTnBranchesService.insert(rptTnBranches);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnbranches:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnBranchesEntity rptTnBranches) {
		rptTnBranchesService.updateById(rptTnBranches);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnbranches:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnBranchesService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
