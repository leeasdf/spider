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

import xin.tianchuang.modules.spider.entity.RptTnBasicInfoEntity;
import xin.tianchuang.modules.spider.service.RptTnBasicInfoService;
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
@RequestMapping("spider/rpttnbasicinfo")
@Api("天眼查-工商信息")
public class RptTnBasicInfoController {
	@Autowired
	private RptTnBasicInfoService rptTnBasicInfoService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnbasicinfo:list")
	@ApiOperation("公司信息-列表查询")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnBasicInfoService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnbasicinfo:info")
	@ApiOperation("公司信息-详情查询")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnBasicInfoEntity rptTnBasicInfo = rptTnBasicInfoService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnBasicInfo", rptTnBasicInfo);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnbasicinfo:info")
	@ApiOperation("公司信息-详情查询")
	public R info(@PathVariable("id") Long id) {
		RptTnBasicInfoEntity rptTnBasicInfo = rptTnBasicInfoService.selectById(id);

		return R.ok().put("rptTnBasicInfo", rptTnBasicInfo);
	}

	/**
	 * 保存
	 */
	@SysLog("保存天眼查-工商信息")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnbasicinfo:save")
	@ApiOperation("保存天眼查-工商信息")
	public R save(@RequestBody RptTnBasicInfoEntity rptTnBasicInfo) {
		rptTnBasicInfoService.insert(rptTnBasicInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改天眼查-工商信息")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnbasicinfo:update")
	@ApiOperation("保存天眼查-工商信息")
	public R update(@RequestBody RptTnBasicInfoEntity rptTnBasicInfo) {
		rptTnBasicInfoService.updateById(rptTnBasicInfo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除天眼查-工商信息")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnbasicinfo:delete")
	@ApiOperation("删除天眼查-工商信息")
	public R delete(@RequestBody Long[] ids) {
		rptTnBasicInfoService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
