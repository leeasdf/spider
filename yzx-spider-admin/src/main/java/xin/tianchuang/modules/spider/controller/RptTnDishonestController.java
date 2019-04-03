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
import xin.tianchuang.modules.spider.entity.RptTnDishonestEntity;
import xin.tianchuang.modules.spider.service.RptTnDishonestService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:38
 */
@RestController
@RequestMapping("spider/rpttndishonest")
@Api("")
public class RptTnDishonestController {
	@Autowired
	private RptTnDishonestService rptTnDishonestService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttndishonest:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnDishonestService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttndishonest:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnDishonestEntity rptTnDishonest = rptTnDishonestService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnDishonest", rptTnDishonest);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttndishonest:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnDishonestEntity rptTnDishonest = rptTnDishonestService.selectById(id);

		return R.ok().put("rptTnDishonest", rptTnDishonest);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttndishonest:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnDishonestEntity rptTnDishonest) {
		rptTnDishonestService.insert(rptTnDishonest);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttndishonest:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnDishonestEntity rptTnDishonest) {
		rptTnDishonestService.updateById(rptTnDishonest);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttndishonest:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnDishonestService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
