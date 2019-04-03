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

import xin.tianchuang.modules.spider.entity.EntIndustrialOutputEntity;
import xin.tianchuang.modules.spider.service.EntIndustrialOutputService;
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
@RequestMapping("spider/entindustrialoutput")
@Api("")
public class EntIndustrialOutputController {
    @Autowired
    private EntIndustrialOutputService entIndustrialOutputService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:entindustrialoutput:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entIndustrialOutputService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{industrialOutputId}")
    @RequiresPermissions("spider:entindustrialoutput:info")
    @ApiOperation("")
    public R info(@PathVariable("industrialOutputId") Integer industrialOutputId){
			EntIndustrialOutputEntity entIndustrialOutput = entIndustrialOutputService.selectById(industrialOutputId);

        return R.ok().put("entIndustrialOutput", entIndustrialOutput);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:entindustrialoutput:save")
    @ApiOperation("")
    public R save(@RequestBody EntIndustrialOutputEntity entIndustrialOutput){
			entIndustrialOutputService.insert(entIndustrialOutput);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:entindustrialoutput:update")
    @ApiOperation("")
    public R update(@RequestBody EntIndustrialOutputEntity entIndustrialOutput){
			entIndustrialOutputService.updateById(entIndustrialOutput);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:entindustrialoutput:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] industrialOutputIds){
			entIndustrialOutputService.deleteBatchIds(Arrays.asList(industrialOutputIds));

        return R.ok();
    }

}
