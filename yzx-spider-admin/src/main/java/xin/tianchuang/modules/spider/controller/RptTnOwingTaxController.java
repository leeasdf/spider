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

import xin.tianchuang.modules.spider.entity.RptTnOwingTaxEntity;
import xin.tianchuang.modules.spider.service.RptTnOwingTaxService;
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
@RequestMapping("spider/rpttnowingtax")
@Api("")
public class RptTnOwingTaxController {
	@Autowired
	private RptTnOwingTaxService rptTnOwingTaxService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnowingtax:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnOwingTaxService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnowingtax:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnOwingTaxEntity rptTnOwingTax = rptTnOwingTaxService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnOwingTax", rptTnOwingTax);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnowingtax:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnOwingTaxEntity rptTnOwingTax = rptTnOwingTaxService.selectById(id);

		return R.ok().put("rptTnOwingTax", rptTnOwingTax);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnowingtax:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnOwingTaxEntity rptTnOwingTax) {
		rptTnOwingTaxService.insert(rptTnOwingTax);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnowingtax:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnOwingTaxEntity rptTnOwingTax) {
		rptTnOwingTaxService.updateById(rptTnOwingTax);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnowingtax:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnOwingTaxService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
