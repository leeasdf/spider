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

import xin.tianchuang.modules.spider.entity.RptTnLicensingXyzgEntity;
import xin.tianchuang.modules.spider.service.RptTnLicensingXyzgService;
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
@RequestMapping("spider/rpttnlicensingxyzg")
@Api("")
public class RptTnLicensingXyzgController {
	@Autowired
	private RptTnLicensingXyzgService rptTnLicensingXyzgService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnlicensingxyzg:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnLicensingXyzgService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnlicensingxyzg:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnLicensingXyzgEntity rptTnLicensingXyzg = rptTnLicensingXyzgService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnLicensingXyzg", rptTnLicensingXyzg);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnlicensingxyzg:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnLicensingXyzgEntity rptTnLicensingXyzg = rptTnLicensingXyzgService.selectById(id);

		return R.ok().put("rptTnLicensingXyzg", rptTnLicensingXyzg);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnlicensingxyzg:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnLicensingXyzgEntity rptTnLicensingXyzg) {
		rptTnLicensingXyzgService.insert(rptTnLicensingXyzg);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnlicensingxyzg:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnLicensingXyzgEntity rptTnLicensingXyzg) {
		rptTnLicensingXyzgService.updateById(rptTnLicensingXyzg);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnlicensingxyzg:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnLicensingXyzgService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
