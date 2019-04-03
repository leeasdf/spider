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

import xin.tianchuang.modules.spider.entity.RptTnWorksRightEntity;
import xin.tianchuang.modules.spider.service.RptTnWorksRightService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:40
 */
@RestController
@RequestMapping("spider/rpttnworksright")
@Api("")
public class RptTnWorksRightController {
	@Autowired
	private RptTnWorksRightService rptTnWorksRightService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnworksright:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnWorksRightService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnworksright:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnWorksRightEntity rptTnWorksRight = rptTnWorksRightService.selectById(id);
		return R.ok().put("rptTnWorksRight", rptTnWorksRight);
	}

	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnworksright:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnWorksRightEntity rptTnWorksRight = rptTnWorksRightService.selectByEnterpriseId(enterpriseId);

		return R.ok().put("rptTnWorksRight", rptTnWorksRight);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnworksright:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnWorksRightEntity rptTnWorksRight) {
		rptTnWorksRightService.insert(rptTnWorksRight);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnworksright:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnWorksRightEntity rptTnWorksRight) {
		rptTnWorksRightService.updateById(rptTnWorksRight);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnworksright:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] enterpriseIds) {
		rptTnWorksRightService.deleteBatchIds(Arrays.asList(enterpriseIds));

		return R.ok();
	}

}
