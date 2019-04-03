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

import xin.tianchuang.modules.spider.entity.RptTnReportShareholderEntity;
import xin.tianchuang.modules.spider.service.RptTnReportShareholderService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业年报-股东及出资信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@RestController
@RequestMapping("spider/rpttnreportshareholder")
@Api(value = "", description = "")
public class RptTnReportShareholderController {
    @Autowired
    private RptTnReportShareholderService rptTnReportShareholderService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreportshareholder:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportShareholderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreportshareholder:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportShareholderEntity rptTnReportShareholder = rptTnReportShareholderService.selectById(id);

        return R.ok().put("rptTnReportShareholder", rptTnReportShareholder);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreportshareholder:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportShareholderEntity rptTnReportShareholder){
			rptTnReportShareholderService.insert(rptTnReportShareholder);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreportshareholder:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportShareholderEntity rptTnReportShareholder){
			rptTnReportShareholderService.updateById(rptTnReportShareholder);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreportshareholder:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportShareholderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
