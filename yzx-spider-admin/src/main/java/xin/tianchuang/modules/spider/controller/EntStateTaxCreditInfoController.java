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

import xin.tianchuang.modules.spider.entity.EntStateTaxCreditInfoEntity;
import xin.tianchuang.modules.spider.service.EntStateTaxCreditInfoService;
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
@RequestMapping("spider/entstatetaxcreditinfo")
@Api("")
public class EntStateTaxCreditInfoController {
    @Autowired
    private EntStateTaxCreditInfoService entStateTaxCreditInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:entstatetaxcreditinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entStateTaxCreditInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stateTaxId}")
    @RequiresPermissions("spider:entstatetaxcreditinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("stateTaxId") Integer stateTaxId){
			EntStateTaxCreditInfoEntity entStateTaxCreditInfo = entStateTaxCreditInfoService.selectById(stateTaxId);

        return R.ok().put("entStateTaxCreditInfo", entStateTaxCreditInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:entstatetaxcreditinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntStateTaxCreditInfoEntity entStateTaxCreditInfo){
			entStateTaxCreditInfoService.insert(entStateTaxCreditInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:entstatetaxcreditinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntStateTaxCreditInfoEntity entStateTaxCreditInfo){
			entStateTaxCreditInfoService.updateById(entStateTaxCreditInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:entstatetaxcreditinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] stateTaxIds){
			entStateTaxCreditInfoService.deleteBatchIds(Arrays.asList(stateTaxIds));

        return R.ok();
    }

}
