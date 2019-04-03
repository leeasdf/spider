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

import xin.tianchuang.modules.spider.entity.RptTnSoftwareRightAuthorEntity;
import xin.tianchuang.modules.spider.service.RptTnSoftwareRightAuthorService;
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
@RequestMapping("spider/rpttnsoftwarerightauthor")
@Api("")
public class RptTnSoftwareRightAuthorController {
	@Autowired
	private RptTnSoftwareRightAuthorService rptTnSoftwareRightAuthorService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnSoftwareRightAuthorService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnSoftwareRightAuthorEntity rptTnSoftwareRightAuthor = rptTnSoftwareRightAuthorService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnSoftwareRightAuthor", rptTnSoftwareRightAuthor);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnSoftwareRightAuthorEntity rptTnSoftwareRightAuthor = rptTnSoftwareRightAuthorService.selectById(id);

		return R.ok().put("rptTnSoftwareRightAuthor", rptTnSoftwareRightAuthor);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnSoftwareRightAuthorEntity rptTnSoftwareRightAuthor) {
		rptTnSoftwareRightAuthorService.insert(rptTnSoftwareRightAuthor);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnSoftwareRightAuthorEntity rptTnSoftwareRightAuthor) {
		rptTnSoftwareRightAuthorService.updateById(rptTnSoftwareRightAuthor);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnsoftwarerightauthor:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnSoftwareRightAuthorService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
