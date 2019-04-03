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

import xin.tianchuang.modules.spider.entity.RptTnReportInvestEntity;
import xin.tianchuang.modules.spider.service.RptTnReportInvestService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业年报-对外投资信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@RestController
@RequestMapping("spider/rpttnreportinvest")
@Api(value = "", description = "")
public class RptTnReportInvestController {
    @Autowired
    private RptTnReportInvestService rptTnReportInvestService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreportinvest:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportInvestService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreportinvest:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportInvestEntity rptTnReportInvest = rptTnReportInvestService.selectById(id);

        return R.ok().put("rptTnReportInvest", rptTnReportInvest);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreportinvest:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportInvestEntity rptTnReportInvest){
			rptTnReportInvestService.insert(rptTnReportInvest);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreportinvest:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportInvestEntity rptTnReportInvest){
			rptTnReportInvestService.updateById(rptTnReportInvest);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreportinvest:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportInvestService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
