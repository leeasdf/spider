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

import xin.tianchuang.modules.spider.entity.RptTnBondEntity;
import xin.tianchuang.modules.spider.service.RptTnBondService;
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
@RequestMapping("spider/rpttnbond")
@Api("")
public class RptTnBondController {
	@Autowired
	private RptTnBondService rptTnBondService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnbond:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnBondService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnbond:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnBondEntity rptTnBond = rptTnBondService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnBond", rptTnBond);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnbond:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnBondEntity rptTnBond = rptTnBondService.selectById(id);

		return R.ok().put("rptTnBond", rptTnBond);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnbond:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnBondEntity rptTnBond) {
		rptTnBondService.insert(rptTnBond);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnbond:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnBondEntity rptTnBond) {
		rptTnBondService.updateById(rptTnBond);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnbond:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnBondService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
