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

import xin.tianchuang.modules.spider.entity.RptTnPatentEntity;
import xin.tianchuang.modules.spider.service.RptTnPatentService;
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
@RequestMapping("spider/rpttnpatent")
@Api("")
public class RptTnPatentController {
	@Autowired
	private RptTnPatentService rptTnPatentService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnpatent:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnPatentService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnpatent:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnPatentEntity rptTnPatent = rptTnPatentService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnPatent", rptTnPatent);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnpatent:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnPatentEntity rptTnPatent = rptTnPatentService.selectById(id);

		return R.ok().put("rptTnPatent", rptTnPatent);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnpatent:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnPatentEntity rptTnPatent) {
		rptTnPatentService.insert(rptTnPatent);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnpatent:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnPatentEntity rptTnPatent) {
		rptTnPatentService.updateById(rptTnPatent);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnpatent:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnPatentService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
