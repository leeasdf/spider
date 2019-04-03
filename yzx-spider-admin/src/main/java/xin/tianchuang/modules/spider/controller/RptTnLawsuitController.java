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

import xin.tianchuang.modules.spider.entity.RptTnLawsuitEntity;
import xin.tianchuang.modules.spider.service.RptTnLawsuitService;
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
@RequestMapping("spider/rpttnlawsuit")
@Api("")
public class RptTnLawsuitController {
	@Autowired
	private RptTnLawsuitService rptTnLawsuitService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnlawsuit:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnLawsuitService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnlawsuit:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnLawsuitEntity rptTnLawsuit = rptTnLawsuitService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnLawsuit", rptTnLawsuit);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnlawsuit:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnLawsuitEntity rptTnLawsuit = rptTnLawsuitService.selectById(id);

		return R.ok().put("rptTnLawsuit", rptTnLawsuit);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnlawsuit:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnLawsuitEntity rptTnLawsuit) {
		rptTnLawsuitService.insert(rptTnLawsuit);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnlawsuit:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnLawsuitEntity rptTnLawsuit) {
		rptTnLawsuitService.updateById(rptTnLawsuit);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnlawsuit:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnLawsuitService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
