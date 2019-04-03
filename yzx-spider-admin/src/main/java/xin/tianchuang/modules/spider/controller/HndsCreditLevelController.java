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

import xin.tianchuang.modules.spider.entity.HndsCreditLevelEntity;
import xin.tianchuang.modules.spider.service.HndsCreditLevelService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 湖南省地方税务局-纳税信用等级信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-21 17:13:05
 */
@RestController
@RequestMapping("spider/hndscreditlevel")
@Api(value = "", description = "")
public class HndsCreditLevelController {
    @Autowired
    private HndsCreditLevelService hndsCreditLevelService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:hndscreditlevel:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hndsCreditLevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:hndscreditlevel:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			HndsCreditLevelEntity hndsCreditLevel = hndsCreditLevelService.selectById(id);

        return R.ok().put("hndsCreditLevel", hndsCreditLevel);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:hndscreditlevel:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody HndsCreditLevelEntity hndsCreditLevel){
			hndsCreditLevelService.insert(hndsCreditLevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:hndscreditlevel:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody HndsCreditLevelEntity hndsCreditLevel){
			hndsCreditLevelService.updateById(hndsCreditLevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:hndscreditlevel:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			hndsCreditLevelService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
