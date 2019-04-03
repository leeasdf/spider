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

import xin.tianchuang.modules.spider.entity.RptTnPersonEntity;
import xin.tianchuang.modules.spider.service.RptTnPersonService;
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
@RequestMapping("spider/rpttnperson")
@Api("")
public class RptTnPersonController {
	@Autowired
	private RptTnPersonService rptTnPersonService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnperson:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnPersonService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnperson:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnPersonEntity rptTnPerson = rptTnPersonService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnPerson", rptTnPerson);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnperson:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnPersonEntity rptTnPerson = rptTnPersonService.selectById(id);

		return R.ok().put("rptTnPerson", rptTnPerson);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnperson:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnPersonEntity rptTnPerson) {
		rptTnPersonService.insert(rptTnPerson);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnperson:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnPersonEntity rptTnPerson) {
		rptTnPersonService.updateById(rptTnPerson);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnperson:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnPersonService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
