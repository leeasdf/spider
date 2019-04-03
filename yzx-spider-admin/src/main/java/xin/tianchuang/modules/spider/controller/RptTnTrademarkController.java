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

import xin.tianchuang.modules.spider.entity.RptTnTrademarkEntity;
import xin.tianchuang.modules.spider.service.RptTnTrademarkService;
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
@RequestMapping("spider/rpttntrademark")
@Api("")
public class RptTnTrademarkController {
	@Autowired
	private RptTnTrademarkService rptTnTrademarkService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttntrademark:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnTrademarkService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttntrademark:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnTrademarkEntity rptTnTrademark = rptTnTrademarkService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnTrademark", rptTnTrademark);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttntrademark:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnTrademarkEntity rptTnTrademark = rptTnTrademarkService.selectById(id);

		return R.ok().put("rptTnTrademark", rptTnTrademark);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttntrademark:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnTrademarkEntity rptTnTrademark) {
		rptTnTrademarkService.insert(rptTnTrademark);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttntrademark:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnTrademarkEntity rptTnTrademark) {
		rptTnTrademarkService.updateById(rptTnTrademark);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttntrademark:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnTrademarkService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
