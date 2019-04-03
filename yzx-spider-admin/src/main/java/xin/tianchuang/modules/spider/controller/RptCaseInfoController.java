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

import xin.tianchuang.modules.spider.entity.RptCaseInfoEntity;
import xin.tianchuang.modules.spider.service.RptCaseInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/rptcaseinfo")
@Api("")
public class RptCaseInfoController {
    @Autowired
    private RptCaseInfoService rptCaseInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptcaseinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptCaseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptcaseinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptCaseInfoEntity rptCaseInfo = rptCaseInfoService.selectById(id);

        return R.ok().put("rptCaseInfo", rptCaseInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptcaseinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptCaseInfoEntity rptCaseInfo){
			rptCaseInfoService.insert(rptCaseInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptcaseinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptCaseInfoEntity rptCaseInfo){
			rptCaseInfoService.updateById(rptCaseInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptcaseinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptCaseInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
