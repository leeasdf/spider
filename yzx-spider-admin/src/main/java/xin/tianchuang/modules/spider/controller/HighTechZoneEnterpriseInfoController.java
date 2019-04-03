package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.biz.TycSpiderBiz;
import xin.tianchuang.modules.spider.entity.HighTechZoneEnterpriseInfoEntity;
import xin.tianchuang.modules.spider.form.MatchListForm;
import xin.tianchuang.modules.spider.service.HighTechZoneEnterpriseInfoService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/hightechzoneenterpriseinfo")
@Api("企业基本信息")
public class HighTechZoneEnterpriseInfoController {
	@Autowired
	private HighTechZoneEnterpriseInfoService highTechZoneEnterpriseInfoService;
	@Autowired
	private TycSpiderBiz tycSpiderBiz;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:list")
	@ApiOperation("列表")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = highTechZoneEnterpriseInfoService.queryPage(params);

		return R.ok().put("page", page);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/match")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:list:match")
	@ApiOperation("列表模糊查找")
	public R matchList(@RequestParam Map<String, Object> params) {
		PageUtils page = highTechZoneEnterpriseInfoService.queryMatchPage(params);
		List<MatchListForm> matchList = new ArrayList<MatchListForm>();
		List<HighTechZoneEnterpriseInfoEntity> list = (List<HighTechZoneEnterpriseInfoEntity>) page.getList();
		MatchListForm match = null;
		for (HighTechZoneEnterpriseInfoEntity entity : list) {
			match = new MatchListForm();
			match.setEnterpriseName(entity.getEnterpriseName());
			match.setId(entity.getId());
			matchList.add(match);
		}
		page.setList(matchList);
		return R.ok().put("page", page);
	}

	@RequestMapping("/retry/{enterpriseName}")
	// @RequiresPermissions("spider:hightechzoneenterpriseinfo:retry")
	@ApiOperation("天眼查人工重试")
	public R retry(@PathVariable("enterpriseName") String enterpriseName) {
		tycSpiderBiz.getTycSpiderEnterpriseDataByName(enterpriseName);
		return R.ok();
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:info")
	@ApiOperation("信息")
	public R info(@PathVariable("id") Long id) {
		HighTechZoneEnterpriseInfoEntity highTechZoneEnterpriseInfo = highTechZoneEnterpriseInfoService.selectById(id);

		return R.ok().put("highTechZoneEnterpriseInfo", highTechZoneEnterpriseInfo);
	}

	/**
	 * 保存
	 */
	@SysLog("保存")
	@PostMapping("/save")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:save")
	@ApiOperation("保存")
	public R save(@RequestBody HighTechZoneEnterpriseInfoEntity highTechZoneEnterpriseInfo) {
		highTechZoneEnterpriseInfoService.insert(highTechZoneEnterpriseInfo);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改")
	@PostMapping("/update")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:update")
	@ApiOperation("修改")
	public R update(@RequestBody HighTechZoneEnterpriseInfoEntity highTechZoneEnterpriseInfo) {
		highTechZoneEnterpriseInfoService.updateById(highTechZoneEnterpriseInfo);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除")
	@PostMapping("/delete")
	@RequiresPermissions("spider:hightechzoneenterpriseinfo:delete")
	@ApiOperation("删除")
	public R delete(@RequestBody Long[] ids) {
		highTechZoneEnterpriseInfoService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
