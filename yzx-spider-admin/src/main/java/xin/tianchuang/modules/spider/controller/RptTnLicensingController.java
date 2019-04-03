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

import xin.tianchuang.modules.spider.entity.RptTnLicensingEntity;
import xin.tianchuang.modules.spider.service.RptTnLicensingService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业行政许可[工商局]信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:47
 */
@RestController
@RequestMapping("spider/rpttnlicensing")
@Api(value = "", description = "")
public class RptTnLicensingController {
    @Autowired
    private RptTnLicensingService rptTnLicensingService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnlicensing:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnLicensingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnlicensing:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnLicensingEntity rptTnLicensing = rptTnLicensingService.selectById(id);

        return R.ok().put("rptTnLicensing", rptTnLicensing);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnlicensing:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnLicensingEntity rptTnLicensing){
			rptTnLicensingService.insert(rptTnLicensing);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnlicensing:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnLicensingEntity rptTnLicensing){
			rptTnLicensingService.updateById(rptTnLicensing);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnlicensing:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnLicensingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
