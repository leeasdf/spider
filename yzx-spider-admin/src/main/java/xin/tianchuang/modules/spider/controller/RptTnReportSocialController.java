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

import xin.tianchuang.modules.spider.entity.RptTnReportSocialEntity;
import xin.tianchuang.modules.spider.service.RptTnReportSocialService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业年报-社保信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-05 17:21:32
 */
@RestController
@RequestMapping("spider/rpttnreportsocial")
@Api(value = "", description = "")
public class RptTnReportSocialController {
    @Autowired
    private RptTnReportSocialService rptTnReportSocialService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnreportsocial:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnReportSocialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnreportsocial:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnReportSocialEntity rptTnReportSocial = rptTnReportSocialService.selectById(id);

        return R.ok().put("rptTnReportSocial", rptTnReportSocial);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnreportsocial:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnReportSocialEntity rptTnReportSocial){
			rptTnReportSocialService.insert(rptTnReportSocial);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnreportsocial:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnReportSocialEntity rptTnReportSocial){
			rptTnReportSocialService.updateById(rptTnReportSocial);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnreportsocial:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnReportSocialService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
