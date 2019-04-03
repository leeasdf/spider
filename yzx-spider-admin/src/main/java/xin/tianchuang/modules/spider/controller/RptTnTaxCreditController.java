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

import xin.tianchuang.modules.spider.entity.RptTnTaxCreditEntity;
import xin.tianchuang.modules.spider.service.RptTnTaxCreditService;
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
@RequestMapping("spider/rpttntaxcredit")
@Api("")
public class RptTnTaxCreditController {
	@Autowired
	private RptTnTaxCreditService rptTnTaxCreditService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttntaxcredit:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnTaxCreditService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttntaxcredit:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnTaxCreditEntity rptTnTaxCredit = rptTnTaxCreditService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnTaxCredit", rptTnTaxCredit);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttntaxcredit:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnTaxCreditEntity rptTnTaxCredit = rptTnTaxCreditService.selectById(id);

		return R.ok().put("rptTnTaxCredit", rptTnTaxCredit);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttntaxcredit:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnTaxCreditEntity rptTnTaxCredit) {
		rptTnTaxCreditService.insert(rptTnTaxCredit);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttntaxcredit:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnTaxCreditEntity rptTnTaxCredit) {
		rptTnTaxCreditService.updateById(rptTnTaxCredit);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttntaxcredit:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnTaxCreditService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
