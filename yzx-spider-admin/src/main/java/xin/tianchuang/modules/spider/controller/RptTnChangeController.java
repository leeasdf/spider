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

import xin.tianchuang.modules.spider.entity.RptTnChangeEntity;
import xin.tianchuang.modules.spider.service.RptTnChangeService;
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
@RequestMapping("spider/rpttnchange")
@Api("")
public class RptTnChangeController {
	@Autowired
	private RptTnChangeService rptTnChangeService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnchange:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnChangeService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnchange:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnChangeEntity rptTnChange = rptTnChangeService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnChange", rptTnChange);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnchange:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnChangeEntity rptTnChange = rptTnChangeService.selectById(id);

		return R.ok().put("rptTnChange", rptTnChange);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnchange:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnChangeEntity rptTnChange) {
		rptTnChangeService.insert(rptTnChange);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnchange:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnChangeEntity rptTnChange) {
		rptTnChangeService.updateById(rptTnChange);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnchange:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnChangeService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
