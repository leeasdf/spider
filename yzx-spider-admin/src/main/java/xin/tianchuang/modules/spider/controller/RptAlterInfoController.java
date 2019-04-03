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

import xin.tianchuang.modules.spider.entity.RptAlterInfoEntity;
import xin.tianchuang.modules.spider.service.RptAlterInfoService;
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
@RequestMapping("spider/rptalterinfo")
@Api("")
public class RptAlterInfoController {
    @Autowired
    private RptAlterInfoService rptAlterInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptalterinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptAlterInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptalterinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptAlterInfoEntity rptAlterInfo = rptAlterInfoService.selectById(id);

        return R.ok().put("rptAlterInfo", rptAlterInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptalterinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptAlterInfoEntity rptAlterInfo){
			rptAlterInfoService.insert(rptAlterInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptalterinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptAlterInfoEntity rptAlterInfo){
			rptAlterInfoService.updateById(rptAlterInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptalterinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptAlterInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
