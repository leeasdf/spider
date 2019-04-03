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

import xin.tianchuang.modules.spider.entity.RptTnClearingEntity;
import xin.tianchuang.modules.spider.service.RptTnClearingService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-清算信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 10:37:24
 */
@RestController
@RequestMapping("spider/rpttnclearing")
@Api(value = "", description = "")
public class RptTnClearingController {
    @Autowired
    private RptTnClearingService rptTnClearingService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnclearing:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnClearingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnclearing:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnClearingEntity rptTnClearing = rptTnClearingService.selectById(id);

        return R.ok().put("rptTnClearing", rptTnClearing);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnclearing:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnClearingEntity rptTnClearing){
			rptTnClearingService.insert(rptTnClearing);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnclearing:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnClearingEntity rptTnClearing){
			rptTnClearingService.updateById(rptTnClearing);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnclearing:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnClearingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
