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

import xin.tianchuang.modules.spider.entity.EntTaxInfoEntity;
import xin.tianchuang.modules.spider.service.EntTaxInfoService;
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
@RequestMapping("spider/enttaxinfo")
@Api("")
public class EntTaxInfoController {
    @Autowired
    private EntTaxInfoService entTaxInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enttaxinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entTaxInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{taxInfoId}")
    @RequiresPermissions("spider:enttaxinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("taxInfoId") Integer taxInfoId){
			EntTaxInfoEntity entTaxInfo = entTaxInfoService.selectById(taxInfoId);

        return R.ok().put("entTaxInfo", entTaxInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enttaxinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntTaxInfoEntity entTaxInfo){
			entTaxInfoService.insert(entTaxInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enttaxinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntTaxInfoEntity entTaxInfo){
			entTaxInfoService.updateById(entTaxInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enttaxinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] taxInfoIds){
			entTaxInfoService.deleteBatchIds(Arrays.asList(taxInfoIds));

        return R.ok();
    }

}
