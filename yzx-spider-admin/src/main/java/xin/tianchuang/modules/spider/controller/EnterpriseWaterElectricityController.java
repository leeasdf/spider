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

import xin.tianchuang.modules.spider.entity.EnterpriseWaterElectricityEntity;
import xin.tianchuang.modules.spider.service.EnterpriseWaterElectricityService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/enterprisewaterelectricity")
@Api("")
public class EnterpriseWaterElectricityController {
    @Autowired
    private EnterpriseWaterElectricityService enterpriseWaterElectricityService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enterprisewaterelectricity:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterpriseWaterElectricityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enterprisewaterelectricity:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EnterpriseWaterElectricityEntity enterpriseWaterElectricity = enterpriseWaterElectricityService.selectById(id);

        return R.ok().put("enterpriseWaterElectricity", enterpriseWaterElectricity);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enterprisewaterelectricity:save")
    @ApiOperation("")
    public R save(@RequestBody EnterpriseWaterElectricityEntity enterpriseWaterElectricity){
			enterpriseWaterElectricityService.insert(enterpriseWaterElectricity);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enterprisewaterelectricity:update")
    @ApiOperation("")
    public R update(@RequestBody EnterpriseWaterElectricityEntity enterpriseWaterElectricity){
			enterpriseWaterElectricityService.updateById(enterpriseWaterElectricity);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enterprisewaterelectricity:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			enterpriseWaterElectricityService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
