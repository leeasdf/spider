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

import xin.tianchuang.modules.spider.entity.RptTnReportWebsiteEntity;
import xin.tianchuang.modules.spider.service.RptTnReportWebsiteService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业年报-网站或网店信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:31
 */
@RestController
@RequestMapping("spider/rpttnreportwebsite")
@Api(value = "", description = "")
public class RptTnReportWebsiteController {
    @Autowired
    private RptTnReportWebsiteService rptTnReportWebsiteService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreportwebsite:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportWebsiteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreportwebsite:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportWebsiteEntity rptTnReportWebsite = rptTnReportWebsiteService.selectById(id);

        return R.ok().put("rptTnReportWebsite", rptTnReportWebsite);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreportwebsite:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportWebsiteEntity rptTnReportWebsite){
			rptTnReportWebsiteService.insert(rptTnReportWebsite);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreportwebsite:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportWebsiteEntity rptTnReportWebsite){
			rptTnReportWebsiteService.updateById(rptTnReportWebsite);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreportwebsite:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportWebsiteService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
