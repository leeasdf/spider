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

import xin.tianchuang.modules.spider.entity.RptTnReportBaseEntity;
import xin.tianchuang.modules.spider.service.RptTnReportBaseService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业年报-企业基本信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@RestController
@RequestMapping("spider/rpttnreportbase")
@Api(value = "", description = "")
public class RptTnReportBaseController {
    @Autowired
    private RptTnReportBaseService rptTnReportBaseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreportbase:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportBaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreportbase:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportBaseEntity rptTnReportBase = rptTnReportBaseService.selectById(id);

        return R.ok().put("rptTnReportBase", rptTnReportBase);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreportbase:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportBaseEntity rptTnReportBase){
			rptTnReportBaseService.insert(rptTnReportBase);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreportbase:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportBaseEntity rptTnReportBase){
			rptTnReportBaseService.updateById(rptTnReportBase);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreportbase:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportBaseService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
