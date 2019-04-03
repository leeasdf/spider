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
import xin.tianchuang.modules.spider.entity.RptTnJudicialAidEntity;
import xin.tianchuang.modules.spider.service.RptTnJudicialAidService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:39
 */
@RestController
@RequestMapping("spider/rpttnjudicialaid")
@Api("")
public class RptTnJudicialAidController {
	@Autowired
	private RptTnJudicialAidService rptTnJudicialAidService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnjudicialaid:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnJudicialAidService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnjudicialaid:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnJudicialAidEntity rptTnJudicialAid = rptTnJudicialAidService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnJudicialAid", rptTnJudicialAid);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnjudicialaid:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnJudicialAidEntity rptTnJudicialAid = rptTnJudicialAidService.selectById(id);

		return R.ok().put("rptTnJudicialAid", rptTnJudicialAid);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnjudicialaid:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnJudicialAidEntity rptTnJudicialAid) {
		rptTnJudicialAidService.insert(rptTnJudicialAid);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnjudicialaid:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnJudicialAidEntity rptTnJudicialAid) {
		rptTnJudicialAidService.updateById(rptTnJudicialAid);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnjudicialaid:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnJudicialAidService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
