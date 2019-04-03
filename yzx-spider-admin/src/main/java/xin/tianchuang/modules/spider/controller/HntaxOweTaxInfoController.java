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

import xin.tianchuang.modules.spider.entity.HntaxOweTaxInfoEntity;
import xin.tianchuang.modules.spider.service.HntaxOweTaxInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 *  湖南省税务局-欠税公告
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-12 17:41:23
 */
@RestController
@RequestMapping("spider/hntaxowetaxinfo")
@Api(value = "", description = "")
public class HntaxOweTaxInfoController {
    @Autowired
    private HntaxOweTaxInfoService hntaxOweTaxInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:hntaxowetaxinfo:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hntaxOweTaxInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:hntaxowetaxinfo:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			HntaxOweTaxInfoEntity hntaxOweTaxInfo = hntaxOweTaxInfoService.selectById(id);

        return R.ok().put("hntaxOweTaxInfo", hntaxOweTaxInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:hntaxowetaxinfo:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody HntaxOweTaxInfoEntity hntaxOweTaxInfo){
			hntaxOweTaxInfoService.insert(hntaxOweTaxInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:hntaxowetaxinfo:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody HntaxOweTaxInfoEntity hntaxOweTaxInfo){
			hntaxOweTaxInfoService.updateById(hntaxOweTaxInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:hntaxowetaxinfo:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			hntaxOweTaxInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
