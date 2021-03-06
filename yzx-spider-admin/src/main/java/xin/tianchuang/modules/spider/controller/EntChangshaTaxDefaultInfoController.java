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

import xin.tianchuang.modules.spider.entity.EntChangshaTaxDefaultInfoEntity;
import xin.tianchuang.modules.spider.service.EntChangshaTaxDefaultInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:34
 */
@RestController
@RequestMapping("spider/entchangshataxdefaultinfo")
@Api("")
public class EntChangshaTaxDefaultInfoController {
    @Autowired
    private EntChangshaTaxDefaultInfoService entChangshaTaxDefaultInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:entchangshataxdefaultinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entChangshaTaxDefaultInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{taxDefaultInfoId}")
    @RequiresPermissions("spider:entchangshataxdefaultinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("taxDefaultInfoId") Integer taxDefaultInfoId){
			EntChangshaTaxDefaultInfoEntity entChangshaTaxDefaultInfo = entChangshaTaxDefaultInfoService.selectById(taxDefaultInfoId);

        return R.ok().put("entChangshaTaxDefaultInfo", entChangshaTaxDefaultInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:entchangshataxdefaultinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntChangshaTaxDefaultInfoEntity entChangshaTaxDefaultInfo){
			entChangshaTaxDefaultInfoService.insert(entChangshaTaxDefaultInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:entchangshataxdefaultinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntChangshaTaxDefaultInfoEntity entChangshaTaxDefaultInfo){
			entChangshaTaxDefaultInfoService.updateById(entChangshaTaxDefaultInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:entchangshataxdefaultinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] taxDefaultInfoIds){
			entChangshaTaxDefaultInfoService.deleteBatchIds(Arrays.asList(taxDefaultInfoIds));

        return R.ok();
    }

}
