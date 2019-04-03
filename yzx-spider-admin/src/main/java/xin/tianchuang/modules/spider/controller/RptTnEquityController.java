package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.Map;

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
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.entity.RptTnEquityEntity;
import xin.tianchuang.modules.spider.service.RptTnEquityService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:38
 */
@RestController
@RequestMapping("spider/rpttnequity")
@Api("")
public class RptTnEquityController {
	@Autowired
	private RptTnEquityService rptTnEquityService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnequity:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnEquityService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnequity:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnEquityEntity rptTnEquity = rptTnEquityService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnEquity", rptTnEquity);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnequity:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnEquityEntity rptTnEquity = rptTnEquityService.selectById(id);

		return R.ok().put("rptTnEquity", rptTnEquity);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnequity:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnEquityEntity rptTnEquity) {
		rptTnEquityService.insert(rptTnEquity);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnequity:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnEquityEntity rptTnEquity) {
		rptTnEquityService.updateById(rptTnEquity);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnequity:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnEquityService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
