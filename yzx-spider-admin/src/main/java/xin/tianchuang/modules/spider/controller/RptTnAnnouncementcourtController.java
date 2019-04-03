package xin.tianchuang.modules.spider.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.modules.spider.entity.RptTnAnnouncementcourtEntity;
import xin.tianchuang.modules.spider.service.RptTnAnnouncementcourtService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:38
 */
@RestController
@RequestMapping("spider/rpttnannouncementcourt")
@Api("天眼查-开庭公告")
public class RptTnAnnouncementcourtController {
	@Autowired
	private RptTnAnnouncementcourtService rptTnAnnouncementcourtService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnannouncementcourt:list")
	@ApiOperation("列表--天眼查开庭公告信息")
	public R list(@RequestParam Map<String, Object> params) {
		System.out.println("1111");
		PageUtils page = rptTnAnnouncementcourtService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnannouncementcourt:info")
	@ApiOperation("信息--天眼查开庭公告信息")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnAnnouncementcourtEntity rptTnAnnouncementcourt = rptTnAnnouncementcourtService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnAnnouncementcourt", rptTnAnnouncementcourt);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnannouncementcourt:info")
	@ApiOperation("信息--天眼查开庭公告信息")
	public R info(@PathVariable("id") Long id) {
		RptTnAnnouncementcourtEntity rptTnAnnouncementcourt = rptTnAnnouncementcourtService.selectById(id);

		return R.ok().put("rptTnAnnouncementcourt", rptTnAnnouncementcourt);
	}

	/**
	 * 保存
	 */
	@SysLog("保存--天眼查开庭公告信息")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnannouncementcourt:save")
	@ApiOperation("保存--天眼查开庭公告信息")
	public R save(@RequestBody RptTnAnnouncementcourtEntity rptTnAnnouncementcourt) {
		rptTnAnnouncementcourtService.insert(rptTnAnnouncementcourt);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改-天眼查开庭公告信息")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnannouncementcourt:update")
	@ApiOperation("-天眼查开庭公告信息")
	public R update(@RequestBody RptTnAnnouncementcourtEntity rptTnAnnouncementcourt) {
		rptTnAnnouncementcourtService.updateById(rptTnAnnouncementcourt);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除-天眼查开庭公告信息")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnannouncementcourt:delete")
	@ApiOperation("删除-天眼查开庭公告信息")
	public R delete(@RequestBody Long[] ids) {
		rptTnAnnouncementcourtService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
