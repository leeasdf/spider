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

import xin.tianchuang.modules.spider.entity.EntHunanStateTaxInfoEntity;
import xin.tianchuang.modules.spider.service.EntHunanStateTaxInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:35
 */
@RestController
@RequestMapping("spider/enthunanstatetaxinfo")
@Api("")
public class EntHunanStateTaxInfoController {
    @Autowired
    private EntHunanStateTaxInfoService entHunanStateTaxInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthunanstatetaxinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHunanStateTaxInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{hunanStateTaxId}")
    @RequiresPermissions("spider:enthunanstatetaxinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("hunanStateTaxId") Integer hunanStateTaxId){
			EntHunanStateTaxInfoEntity entHunanStateTaxInfo = entHunanStateTaxInfoService.selectById(hunanStateTaxId);

        return R.ok().put("entHunanStateTaxInfo", entHunanStateTaxInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthunanstatetaxinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntHunanStateTaxInfoEntity entHunanStateTaxInfo){
			entHunanStateTaxInfoService.insert(entHunanStateTaxInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthunanstatetaxinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntHunanStateTaxInfoEntity entHunanStateTaxInfo){
			entHunanStateTaxInfoService.updateById(entHunanStateTaxInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthunanstatetaxinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] hunanStateTaxIds){
			entHunanStateTaxInfoService.deleteBatchIds(Arrays.asList(hunanStateTaxIds));

        return R.ok();
    }

}
