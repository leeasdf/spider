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

import xin.tianchuang.modules.spider.entity.RptTnReportEntity;
import xin.tianchuang.modules.spider.service.RptTnReportService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-年报信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
@RestController
@RequestMapping("spider/rpttnreport")
@Api(value = "", description = "")
public class RptTnReportController {
    @Autowired
    private RptTnReportService rptTnReportService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreport:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreport:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportEntity rptTnReport = rptTnReportService.selectById(id);

        return R.ok().put("rptTnReport", rptTnReport);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreport:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportEntity rptTnReport){
			rptTnReportService.insert(rptTnReport);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreport:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportEntity rptTnReport){
			rptTnReportService.updateById(rptTnReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreport:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
