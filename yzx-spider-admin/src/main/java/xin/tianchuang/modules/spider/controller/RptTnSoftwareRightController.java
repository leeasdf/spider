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

import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightEntity;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightService;
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
@RequestMapping("spider/rpttnsoftwareright")
@Api("")
public class RptTnSoftwareRightController {
	@Autowired
	private RptTnSoftwareRightService rptTnSoftwareRightService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnsoftwareright:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnSoftwareRightService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnsoftwareright:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnSoftwareRightEntity rptTnSoftwareRight = rptTnSoftwareRightService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnSoftwareRight", rptTnSoftwareRight);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnsoftwareright:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnSoftwareRightEntity rptTnSoftwareRight = rptTnSoftwareRightService.selectById(id);

		return R.ok().put("rptTnSoftwareRight", rptTnSoftwareRight);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnsoftwareright:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnSoftwareRightEntity rptTnSoftwareRight) {
		rptTnSoftwareRightService.insert(rptTnSoftwareRight);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnsoftwareright:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnSoftwareRightEntity rptTnSoftwareRight) {
		rptTnSoftwareRightService.updateById(rptTnSoftwareRight);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnsoftwareright:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnSoftwareRightService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
