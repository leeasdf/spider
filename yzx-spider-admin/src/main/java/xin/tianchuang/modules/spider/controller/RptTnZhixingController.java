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

import xin.tianchuang.modules.spider.entity.RptTnZhixingEntity;
import xin.tianchuang.modules.spider.service.RptTnZhixingService;
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
@RequestMapping("spider/rpttnzhixing")
@Api("")
public class RptTnZhixingController {
	@Autowired
	private RptTnZhixingService rptTnZhixingService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnzhixing:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnZhixingService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnzhixing:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnZhixingEntity rptTnZhixing = rptTnZhixingService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnZhixing", rptTnZhixing);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnzhixing:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnZhixingEntity rptTnZhixing = rptTnZhixingService.selectById(id);

		return R.ok().put("rptTnZhixing", rptTnZhixing);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnzhixing:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnZhixingEntity rptTnZhixing) {
		rptTnZhixingService.insert(rptTnZhixing);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnzhixing:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnZhixingEntity rptTnZhixing) {
		rptTnZhixingService.updateById(rptTnZhixing);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnzhixing:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnZhixingService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
