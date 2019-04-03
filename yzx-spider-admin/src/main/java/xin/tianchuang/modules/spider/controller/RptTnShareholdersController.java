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

import xin.tianchuang.modules.spider.entity.RptTnShareholdersEntity;
import xin.tianchuang.modules.spider.service.RptTnShareholdersService;
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
@RequestMapping("spider/rpttnshareholders")
@Api("")
public class RptTnShareholdersController {
	@Autowired
	private RptTnShareholdersService rptTnShareholdersService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnshareholders:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnShareholdersService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnshareholders:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnShareholdersEntity rptTnShareholders = rptTnShareholdersService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnShareholders", rptTnShareholders);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnshareholders:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnShareholdersEntity rptTnShareholders = rptTnShareholdersService.selectById(id);

		return R.ok().put("rptTnShareholders", rptTnShareholders);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnshareholders:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnShareholdersEntity rptTnShareholders) {
		rptTnShareholdersService.insert(rptTnShareholders);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnshareholders:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnShareholdersEntity rptTnShareholders) {
		rptTnShareholdersService.updateById(rptTnShareholders);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnshareholders:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnShareholdersService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
