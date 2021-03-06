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

import xin.tianchuang.modules.spider.entity.RptTnCheckEntity;
import xin.tianchuang.modules.spider.service.RptTnCheckService;
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
@RequestMapping("spider/rpttncheck")
@Api("")
public class RptTnCheckController {
	@Autowired
	private RptTnCheckService rptTnCheckService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttncheck:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnCheckService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttncheck:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnCheckEntity rptTnCheck = rptTnCheckService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnCheck", rptTnCheck);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttncheck:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnCheckEntity rptTnCheck = rptTnCheckService.selectById(id);

		return R.ok().put("rptTnCheck", rptTnCheck);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttncheck:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnCheckEntity rptTnCheck) {
		rptTnCheckService.insert(rptTnCheck);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttncheck:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnCheckEntity rptTnCheck) {
		rptTnCheckService.updateById(rptTnCheck);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttncheck:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnCheckService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
