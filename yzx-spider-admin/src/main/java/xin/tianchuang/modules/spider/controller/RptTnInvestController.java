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

import xin.tianchuang.modules.spider.entity.RptTnInvestEntity;
import xin.tianchuang.modules.spider.service.RptTnInvestService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:39
 */
@RestController
@RequestMapping("spider/rpttninvest")
@Api("")
public class RptTnInvestController {
	@Autowired
	private RptTnInvestService rptTnInvestService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttninvest:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnInvestService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttninvest:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnInvestEntity rptTnInvest = rptTnInvestService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnInvest", rptTnInvest);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttninvest:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnInvestEntity rptTnInvest = rptTnInvestService.selectById(id);

		return R.ok().put("rptTnInvest", rptTnInvest);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttninvest:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnInvestEntity rptTnInvest) {
		rptTnInvestService.insert(rptTnInvest);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttninvest:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnInvestEntity rptTnInvest) {
		rptTnInvestService.updateById(rptTnInvest);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttninvest:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnInvestService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
