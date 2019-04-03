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

import xin.tianchuang.modules.spider.entity.RptTnPurchaselandEntity;
import xin.tianchuang.modules.spider.service.RptTnPurchaselandService;
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
@RequestMapping("spider/rpttnpurchaseland")
@Api("")
public class RptTnPurchaselandController {
	@Autowired
	private RptTnPurchaselandService rptTnPurchaselandService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnpurchaseland:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnPurchaselandService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnpurchaseland:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnPurchaselandEntity rptTnPurchaseland = rptTnPurchaselandService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnPurchaseland", rptTnPurchaseland);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnpurchaseland:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnPurchaselandEntity rptTnPurchaseland = rptTnPurchaselandService.selectById(id);

		return R.ok().put("rptTnPurchaseland", rptTnPurchaseland);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnpurchaseland:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnPurchaselandEntity rptTnPurchaseland) {
		rptTnPurchaselandService.insert(rptTnPurchaseland);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnpurchaseland:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnPurchaselandEntity rptTnPurchaseland) {
		rptTnPurchaselandService.updateById(rptTnPurchaseland);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnpurchaseland:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnPurchaselandService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
