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

import xin.tianchuang.modules.spider.entity.TycPageRecordEntity;
import xin.tianchuang.modules.spider.service.TycPageRecordService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:40
 */
@RestController
@RequestMapping("spider/tycpagerecord")
@Api("")
public class TycPageRecordController {
    @Autowired
    private TycPageRecordService tycPageRecordService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:tycpagerecord:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tycPageRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:tycpagerecord:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			TycPageRecordEntity tycPageRecord = tycPageRecordService.selectById(id);

        return R.ok().put("tycPageRecord", tycPageRecord);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:tycpagerecord:save")
    @ApiOperation("")
    public R save(@RequestBody TycPageRecordEntity tycPageRecord){
			tycPageRecordService.insert(tycPageRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:tycpagerecord:update")
    @ApiOperation("")
    public R update(@RequestBody TycPageRecordEntity tycPageRecord){
			tycPageRecordService.updateById(tycPageRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:tycpagerecord:delete")
    @ApiOperation("")
    public R delete(@RequestBody Integer[] ids){
			tycPageRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
