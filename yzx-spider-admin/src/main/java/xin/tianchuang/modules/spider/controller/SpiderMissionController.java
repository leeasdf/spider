package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.entity.SpiderMissionEntity;
import xin.tianchuang.modules.spider.service.SpiderMissionService;

import java.util.Arrays;
import java.util.Map;


/**
 * 爬虫任务
 *
 * @author hui.deng
 * @email
 * @date 2018-10-17 17:04:27
 */
@RestController
@RequestMapping("spider/spidermission")
@Api(value = "", description = "爬虫任务")
public class SpiderMissionController {
    @Autowired
    private SpiderMissionService spiderMissionService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:spidermission:list")
    @ApiOperation(value = "", notes = "")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = spiderMissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:spidermission:info")
    @ApiOperation(value = "", notes = "")
    public R info(@PathVariable("id") Long id) {
        SpiderMissionEntity spiderMission = spiderMissionService.selectById(id);

        return R.ok().put("spiderMission", spiderMission);
    }

    /**
     * 保存
     */
    @SysLog("保存爬虫任务")
    @PostMapping("/save")
    @RequiresPermissions("spider:spidermission:save")
    @ApiOperation(value = "", notes = "")
    public R save(@RequestBody SpiderMissionEntity spiderMission) {
        spiderMissionService.insert(spiderMission);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改爬虫任务")
    @PostMapping("/update")
    @RequiresPermissions("spider:spidermission:update")
    @ApiOperation(value = "", notes = "")
    public R update(@RequestBody SpiderMissionEntity spiderMission) {
        spiderMissionService.updateById(spiderMission);
        return R.ok();
    }

    /**
     * 删除
     */
//    @SysLog("删除爬虫任务")
//    @PostMapping("/delete")
//    @RequiresPermissions("spider:spidermission:delete")
//    @ApiOperation(value = "", notes = "")
//    public R delete(@RequestBody Long[] ids) {
//        spiderMissionService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }

}
