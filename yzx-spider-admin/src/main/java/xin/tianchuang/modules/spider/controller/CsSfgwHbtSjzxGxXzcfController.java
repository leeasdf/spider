package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.entity.CsSfgwHbtSjzxGxXzcfEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtSjzxGxXzcfService;

/**
 * 
 *
 * @author hui.deng
 * @email
 * @date 2018-09-26 11:44:34
 */
@RestController
@RequestMapping("spider/cssfgwhbtsjzxgxxzcf")
@Api("")
public class CsSfgwHbtSjzxGxXzcfController {
	@Autowired
	private CsSfgwHbtSjzxGxXzcfService csSfgwHbtSjzxGxXzcfService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("spider:cssfgwhbtsjzxgxxzcf:list")
	@ApiOperation("")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = csSfgwHbtSjzxGxXzcfService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{isinvalid}")
	@RequiresPermissions("spider:cssfgwhbtsjzxgxxzcf:info")
	@ApiOperation("")
	public R info(@PathVariable("isinvalid") Integer isinvalid) {
		CsSfgwHbtSjzxGxXzcfEntity csSfgwHbtSjzxGxXzcf = csSfgwHbtSjzxGxXzcfService.selectById(isinvalid);

		return R.ok().put("csSfgwHbtSjzxGxXzcf", csSfgwHbtSjzxGxXzcf);
	}

	/**
	 * 保存
	 */
	@SysLog("保存xx")
	@PostMapping("/save")
	@RequiresPermissions("spider:cssfgwhbtsjzxgxxzcf:save")
	@ApiOperation("")
	public R save(@RequestBody CsSfgwHbtSjzxGxXzcfEntity csSfgwHbtSjzxGxXzcf) {
		csSfgwHbtSjzxGxXzcfService.insert(csSfgwHbtSjzxGxXzcf);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@SysLog("修改xx")
	@PostMapping("/update")
	@RequiresPermissions("spider:cssfgwhbtsjzxgxxzcf:update")
	@ApiOperation("")
	public R update(@RequestBody CsSfgwHbtSjzxGxXzcfEntity csSfgwHbtSjzxGxXzcf) {
		csSfgwHbtSjzxGxXzcfService.updateById(csSfgwHbtSjzxGxXzcf);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@SysLog("删除xx")
	@PostMapping("/delete")
	@RequiresPermissions("spider:cssfgwhbtsjzxgxxzcf:delete")
	@ApiOperation("")
	public R delete(@RequestBody Long[] isinvalids) {
		csSfgwHbtSjzxGxXzcfService.deleteBatchIds(Arrays.asList(isinvalids));

		return R.ok();
	}

}
