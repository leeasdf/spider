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

import xin.tianchuang.modules.spider.entity.HndsTaxInfoEntity;
import xin.tianchuang.modules.spider.service.HndsTaxInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 湖南省地方税务局-税务登记信息信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-25 09:04:52
 */
@RestController
@RequestMapping("spider/hndstaxinfo")
@Api(value = "", description = "")
public class HndsTaxInfoController {
    @Autowired
    private HndsTaxInfoService hndsTaxInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:hndstaxinfo:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hndsTaxInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:hndstaxinfo:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			HndsTaxInfoEntity hndsTaxInfo = hndsTaxInfoService.selectById(id);

        return R.ok().put("hndsTaxInfo", hndsTaxInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:hndstaxinfo:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody HndsTaxInfoEntity hndsTaxInfo){
			hndsTaxInfoService.insert(hndsTaxInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:hndstaxinfo:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody HndsTaxInfoEntity hndsTaxInfo){
			hndsTaxInfoService.updateById(hndsTaxInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:hndstaxinfo:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			hndsTaxInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
