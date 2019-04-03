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

import xin.tianchuang.modules.spider.entity.RptTaxInfoEntity;
import xin.tianchuang.modules.spider.service.RptTaxInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:37
 */
@RestController
@RequestMapping("spider/rpttaxinfo")
@Api("")
public class RptTaxInfoController {
    @Autowired
    private RptTaxInfoService rptTaxInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttaxinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTaxInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttaxinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptTaxInfoEntity rptTaxInfo = rptTaxInfoService.selectById(id);

        return R.ok().put("rptTaxInfo", rptTaxInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttaxinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptTaxInfoEntity rptTaxInfo){
			rptTaxInfoService.insert(rptTaxInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttaxinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptTaxInfoEntity rptTaxInfo){
			rptTaxInfoService.updateById(rptTaxInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttaxinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptTaxInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
