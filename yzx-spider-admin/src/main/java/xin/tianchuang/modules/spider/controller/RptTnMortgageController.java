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

import xin.tianchuang.modules.spider.entity.RptTnMortgageEntity;
import xin.tianchuang.modules.spider.service.RptTnMortgageService;
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
@RequestMapping("spider/rpttnmortgage")
@Api("")
public class RptTnMortgageController {
	@Autowired
	private RptTnMortgageService rptTnMortgageService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnmortgage:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnMortgageService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnabnormal:info")
	@ApiOperation("天眼查-经营异常")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnMortgageEntity rptTnMortgage = rptTnMortgageService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnMortgage", rptTnMortgage);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnmortgage:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnMortgageEntity rptTnMortgage = rptTnMortgageService.selectById(id);

		return R.ok().put("rptTnMortgage", rptTnMortgage);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnmortgage:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnMortgageEntity rptTnMortgage) {
		rptTnMortgageService.insert(rptTnMortgage);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnmortgage:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnMortgageEntity rptTnMortgage) {
		rptTnMortgageService.updateById(rptTnMortgage);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnmortgage:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnMortgageService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
