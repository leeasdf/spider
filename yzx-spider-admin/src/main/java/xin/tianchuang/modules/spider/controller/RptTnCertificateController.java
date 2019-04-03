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

import xin.tianchuang.modules.spider.entity.RptTnCertificateEntity;
import xin.tianchuang.modules.spider.service.RptTnCertificateService;
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
@RequestMapping("spider/rpttncertificate")
@Api("")
public class RptTnCertificateController {
	@Autowired
	private RptTnCertificateService rptTnCertificateService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttncertificate:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnCertificateService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttncertificate:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnCertificateEntity rptTnCertificate = rptTnCertificateService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnCertificate", rptTnCertificate);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttncertificate:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnCertificateEntity rptTnCertificate = rptTnCertificateService.selectById(id);

		return R.ok().put("rptTnCertificate", rptTnCertificate);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttncertificate:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnCertificateEntity rptTnCertificate) {
		rptTnCertificateService.insert(rptTnCertificate);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttncertificate:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnCertificateEntity rptTnCertificate) {
		rptTnCertificateService.updateById(rptTnCertificate);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttncertificate:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnCertificateService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
