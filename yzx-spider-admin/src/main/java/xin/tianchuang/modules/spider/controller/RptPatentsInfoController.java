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

import xin.tianchuang.modules.spider.entity.RptPatentsInfoEntity;
import xin.tianchuang.modules.spider.service.RptPatentsInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:37
 */
@RestController
@RequestMapping("spider/rptpatentsinfo")
@Api("")
public class RptPatentsInfoController {
    @Autowired
    private RptPatentsInfoService rptPatentsInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptpatentsinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptPatentsInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptpatentsinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptPatentsInfoEntity rptPatentsInfo = rptPatentsInfoService.selectById(id);

        return R.ok().put("rptPatentsInfo", rptPatentsInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptpatentsinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptPatentsInfoEntity rptPatentsInfo){
			rptPatentsInfoService.insert(rptPatentsInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptpatentsinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptPatentsInfoEntity rptPatentsInfo){
			rptPatentsInfoService.updateById(rptPatentsInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptpatentsinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptPatentsInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
