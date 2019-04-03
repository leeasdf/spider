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

import xin.tianchuang.modules.spider.entity.RptTnIcpEntity;
import xin.tianchuang.modules.spider.service.RptTnIcpService;
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
@RequestMapping("spider/rpttnicp")
@Api("")
public class RptTnIcpController {
	@Autowired
	private RptTnIcpService rptTnIcpService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttnicp:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnIcpService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttnicp:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnIcpEntity rptTnIcp = rptTnIcpService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnIcp", rptTnIcp);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttnicp:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnIcpEntity rptTnIcp = rptTnIcpService.selectById(id);

		return R.ok().put("rptTnIcp", rptTnIcp);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttnicp:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnIcpEntity rptTnIcp) {
		rptTnIcpService.insert(rptTnIcp);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttnicp:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnIcpEntity rptTnIcp) {
		rptTnIcpService.updateById(rptTnIcp);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttnicp:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnIcpService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
