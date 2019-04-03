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

import xin.tianchuang.modules.spider.entity.RptTnCourtNoticeEntity;
import xin.tianchuang.modules.spider.service.RptTnCourtNoticeService;
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
@RequestMapping("spider/rpttncourtnotice")
@Api("")
public class RptTnCourtNoticeController {
	@Autowired
	private RptTnCourtNoticeService rptTnCourtNoticeService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:rpttncourtnotice:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = rptTnCourtNoticeService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/searchInfo/{enterpriseId}")
	@RequiresPermissions("spider:rpttncourtnotice:info")
	@ApiOperation("")
	public R infoByEnterpriseId(@PathVariable("enterpriseId") Long enterpriseId) {
		RptTnCourtNoticeEntity rptTnCourtNotice = rptTnCourtNoticeService.selectByEnterpriseId(enterpriseId);
		return R.ok().put("rptTnCourtNotice", rptTnCourtNotice);
	}

	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:rpttncourtnotice:info")
	@ApiOperation("")
	public R info(@PathVariable("id") Long id) {
		RptTnCourtNoticeEntity rptTnCourtNotice = rptTnCourtNoticeService.selectById(id);

		return R.ok().put("rptTnCourtNotice", rptTnCourtNotice);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:rpttncourtnotice:save")
	@ApiOperation("")
	public R save(@RequestBody RptTnCourtNoticeEntity rptTnCourtNotice) {
		rptTnCourtNoticeService.insert(rptTnCourtNotice);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:rpttncourtnotice:update")
	@ApiOperation("")
	public R update(@RequestBody RptTnCourtNoticeEntity rptTnCourtNotice) {
		rptTnCourtNoticeService.updateById(rptTnCourtNotice);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:rpttncourtnotice:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] ids) {
		rptTnCourtNoticeService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
