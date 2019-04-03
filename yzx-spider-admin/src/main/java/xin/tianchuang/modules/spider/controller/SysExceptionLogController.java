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

import xin.tianchuang.modules.spider.entity.SysExceptionLogEntity;
import xin.tianchuang.modules.spider.service.SysExceptionLogService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-26 15:20:00
 */
@RestController
@RequestMapping("spider/sysexceptionlog")
@Api(value = "", description = "")
public class SysExceptionLogController {
    @Autowired
    private SysExceptionLogService sysExceptionLogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:sysexceptionlog:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysExceptionLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:sysexceptionlog:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			SysExceptionLogEntity sysExceptionLog = sysExceptionLogService.selectById(id);

        return R.ok().put("sysExceptionLog", sysExceptionLog);
    }

//    /**
//     * 保存
//     */
//    @SysLog("保存异常")
//    @PostMapping("/save")
//    @RequiresPermissions("spider:sysexceptionlog:save")
//    @ApiOperation(value = "", notes="")
//    public R save(@RequestBody SysExceptionLogEntity sysExceptionLog){
//			sysExceptionLogService.insert(sysExceptionLog);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @SysLog("修改")
//    @PostMapping("/update")
//    @RequiresPermissions("spider:sysexceptionlog:update")
//    @ApiOperation(value = "", notes="")
//    public R update(@RequestBody SysExceptionLogEntity sysExceptionLog){
//			sysExceptionLogService.updateById(sysExceptionLog);
//
//        return R.ok();
//    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:sysexceptionlog:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			sysExceptionLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
