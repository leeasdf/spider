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

import xin.tianchuang.modules.spider.entity.RptEntinvInfoEntity;
import xin.tianchuang.modules.spider.service.RptEntinvInfoService;
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
@RequestMapping("spider/rptentinvinfo")
@Api("")
public class RptEntinvInfoController {
    @Autowired
    private RptEntinvInfoService rptEntinvInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptentinvinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptEntinvInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptentinvinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptEntinvInfoEntity rptEntinvInfo = rptEntinvInfoService.selectById(id);

        return R.ok().put("rptEntinvInfo", rptEntinvInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptentinvinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptEntinvInfoEntity rptEntinvInfo){
			rptEntinvInfoService.insert(rptEntinvInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptentinvinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptEntinvInfoEntity rptEntinvInfo){
			rptEntinvInfoService.updateById(rptEntinvInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptentinvinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptEntinvInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
