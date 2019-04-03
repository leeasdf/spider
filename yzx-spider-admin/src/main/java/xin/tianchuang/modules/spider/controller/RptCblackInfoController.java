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

import xin.tianchuang.modules.spider.entity.RptCblackInfoEntity;
import xin.tianchuang.modules.spider.service.RptCblackInfoService;
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
@RequestMapping("spider/rptcblackinfo")
@Api("")
public class RptCblackInfoController {
    @Autowired
    private RptCblackInfoService rptCblackInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptcblackinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptCblackInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptcblackinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptCblackInfoEntity rptCblackInfo = rptCblackInfoService.selectById(id);

        return R.ok().put("rptCblackInfo", rptCblackInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptcblackinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptCblackInfoEntity rptCblackInfo){
			rptCblackInfoService.insert(rptCblackInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptcblackinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptCblackInfoEntity rptCblackInfo){
			rptCblackInfoService.updateById(rptCblackInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptcblackinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptCblackInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
