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
import xin.tianchuang.modules.spider.entity.RptTnIllegalEntity;
import xin.tianchuang.modules.spider.service.RptTnIllegalService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:38
 */
@RestController
@RequestMapping("spider/rpttnillegal")
@Api("")
public class RptTnIllegalController {
	@Autowired
	private RptTnIllegalService rptTnIllegalService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnillegal:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnIllegalService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnillegal:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnIllegalEntity rptTnIllegal = rptTnIllegalService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnIllegal", rptTnIllegal);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnillegal:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnIllegalEntity rptTnIllegal = rptTnIllegalService.selectById(id);

		return R.ok().put("rptTnIllegal", rptTnIllegal);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnillegal:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnIllegalEntity rptTnIllegal) {
		rptTnIllegalService.insert(rptTnIllegal);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnillegal:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnIllegalEntity rptTnIllegal) {
		rptTnIllegalService.updateById(rptTnIllegal);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnillegal:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnIllegalService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
