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

import xin.tianchuang.modules.spider.entity.XylgDsjCityTaxOwingEntity;
import xin.tianchuang.modules.spider.service.XylgDsjCityTaxOwingService;
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
@RequestMapping("spider/xylgdsjcitytaxowing")
@Api("")
public class XylgDsjCityTaxOwingController {
    @Autowired
    private XylgDsjCityTaxOwingService xylgDsjCityTaxOwingService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:xylgdsjcitytaxowing:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = xylgDsjCityTaxOwingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:xylgdsjcitytaxowing:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			XylgDsjCityTaxOwingEntity xylgDsjCityTaxOwing = xylgDsjCityTaxOwingService.selectById(id);

        return R.ok().put("xylgDsjCityTaxOwing", xylgDsjCityTaxOwing);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:xylgdsjcitytaxowing:save")
    @ApiOperation("")
    public R save(@RequestBody XylgDsjCityTaxOwingEntity xylgDsjCityTaxOwing){
			xylgDsjCityTaxOwingService.insert(xylgDsjCityTaxOwing);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:xylgdsjcitytaxowing:update")
    @ApiOperation("")
    public R update(@RequestBody XylgDsjCityTaxOwingEntity xylgDsjCityTaxOwing){
			xylgDsjCityTaxOwingService.updateById(xylgDsjCityTaxOwing);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:xylgdsjcitytaxowing:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids){
			xylgDsjCityTaxOwingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
