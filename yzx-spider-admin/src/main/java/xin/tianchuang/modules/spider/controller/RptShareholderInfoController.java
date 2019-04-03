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

import xin.tianchuang.modules.spider.entity.RptShareholderInfoEntity;
import xin.tianchuang.modules.spider.service.RptShareholderInfoService;
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
@RequestMapping("spider/rptshareholderinfo")
@Api("")
public class RptShareholderInfoController {
    @Autowired
    private RptShareholderInfoService rptShareholderInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptshareholderinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptShareholderInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptshareholderinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptShareholderInfoEntity rptShareholderInfo = rptShareholderInfoService.selectById(id);

        return R.ok().put("rptShareholderInfo", rptShareholderInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptshareholderinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptShareholderInfoEntity rptShareholderInfo){
			rptShareholderInfoService.insert(rptShareholderInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptshareholderinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptShareholderInfoEntity rptShareholderInfo){
			rptShareholderInfoService.updateById(rptShareholderInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptshareholderinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptShareholderInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
