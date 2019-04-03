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

import xin.tianchuang.modules.spider.entity.RptTnAbnormalEntity;
import xin.tianchuang.modules.spider.service.RptTnAbnormalService;
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
@RequestMapping("spider/rpttnabnormal")
@Api("天眼查-经营异常")
public class RptTnAbnormalController {
	@Autowired
	private RptTnAbnormalService rptTnAbnormalService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnabnormal:list")
	@ApiOperation("天眼查-经营异常列表信息")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnAbnormalService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnabnormal:info")
	@ApiOperation("天眼查-经营异常")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnAbnormalEntity rptTnAbnormal = rptTnAbnormalService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnAbnormal", rptTnAbnormal);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnabnormal:info")
	@ApiOperation("天眼查-经营异常")
	public R info(@PathVariable("id") Long id) {
		RptTnAbnormalEntity rptTnAbnormal = rptTnAbnormalService.selectById(id);

		return R.ok().put("rptTnAbnormal", rptTnAbnormal);
	}

	/**
	 * 保存
	 */
	@SysLog("保存天眼查-经营异常")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnabnormal:save")
	@ApiOperation("天眼查-经营异常")
	public R save(@RequestBody RptTnAbnormalEntity rptTnAbnormal) {
		rptTnAbnormalService.insert(rptTnAbnormal);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改天眼查-经营异常")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnabnormal:update")
	@ApiOperation("天眼查-经营异常")
	public R update(@RequestBody RptTnAbnormalEntity rptTnAbnormal) {
		rptTnAbnormalService.updateById(rptTnAbnormal);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除天眼查-经营异常")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnabnormal:delete")
	@ApiOperation("天眼查-经营异常")
	public R delete(@RequestBody Long[] ids) {
		rptTnAbnormalService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
