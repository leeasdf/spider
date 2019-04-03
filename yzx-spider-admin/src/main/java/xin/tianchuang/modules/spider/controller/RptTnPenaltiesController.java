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

import xin.tianchuang.modules.spider.entity.RptTnPenaltiesEntity;
import xin.tianchuang.modules.spider.service.RptTnPenaltiesService;
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
@RequestMapping("spider/rpttnpenalties")
@Api("")
public class RptTnPenaltiesController {
	@Autowired
	private RptTnPenaltiesService rptTnPenaltiesService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnpenalties:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnPenaltiesService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnpenalties:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnPenaltiesEntity rptTnPenalties = rptTnPenaltiesService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnPenalties", rptTnPenalties);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnpenalties:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnPenaltiesEntity rptTnPenalties = rptTnPenaltiesService.selectById(id);

		return R.ok().put("rptTnPenalties", rptTnPenalties);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnpenalties:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnPenaltiesEntity rptTnPenalties) {
		rptTnPenaltiesService.insert(rptTnPenalties);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnpenalties:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnPenaltiesEntity rptTnPenalties) {
		rptTnPenaltiesService.updateById(rptTnPenalties);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnpenalties:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnPenaltiesService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
