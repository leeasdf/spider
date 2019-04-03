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

import xin.tianchuang.modules.spider.entity.RptTnProductEntity;
import xin.tianchuang.modules.spider.service.RptTnProductService;
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
@RequestMapping("spider/rpttnproduct")
@Api("")
public class RptTnProductController {
	@Autowired
	private RptTnProductService rptTnProductService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnproduct:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnProductService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnproduct:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnProductEntity rptTnProduct = rptTnProductService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnProduct", rptTnProduct);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnproduct:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnProductEntity rptTnProduct = rptTnProductService.selectById(id);

		return R.ok().put("rptTnProduct", rptTnProduct);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnproduct:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnProductEntity rptTnProduct) {
		rptTnProductService.insert(rptTnProduct);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnproduct:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnProductEntity rptTnProduct) {
		rptTnProductService.updateById(rptTnProduct);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnproduct:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnProductService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
