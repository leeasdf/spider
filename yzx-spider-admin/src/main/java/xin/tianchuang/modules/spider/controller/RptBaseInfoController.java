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

import xin.tianchuang.modules.spider.entity.RptBaseInfoEntity;
import xin.tianchuang.modules.spider.service.RptBaseInfoService;
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
@RequestMapping("spider/rptbaseinfo")
@Api("")
public class RptBaseInfoController {
    @Autowired
    private RptBaseInfoService rptBaseInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptbaseinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptBaseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptbaseinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptBaseInfoEntity rptBaseInfo = rptBaseInfoService.selectById(id);

        return R.ok().put("rptBaseInfo", rptBaseInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptbaseinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptBaseInfoEntity rptBaseInfo){
			rptBaseInfoService.insert(rptBaseInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptbaseinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptBaseInfoEntity rptBaseInfo){
			rptBaseInfoService.updateById(rptBaseInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptbaseinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptBaseInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
