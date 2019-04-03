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

import xin.tianchuang.modules.spider.entity.RptTcxyCompanySoftwareCopyrightEntity;
import xin.tianchuang.modules.spider.service.RptTcxyCompanySoftwareCopyrightService;
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
@RequestMapping("spider/rpttcxycompanysoftwarecopyright")
@Api("")
public class RptTcxyCompanySoftwareCopyrightController {
    @Autowired
    private RptTcxyCompanySoftwareCopyrightService rptTcxyCompanySoftwareCopyrightService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttcxycompanysoftwarecopyright:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTcxyCompanySoftwareCopyrightService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttcxycompanysoftwarecopyright:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptTcxyCompanySoftwareCopyrightEntity rptTcxyCompanySoftwareCopyright = rptTcxyCompanySoftwareCopyrightService.selectById(id);

        return R.ok().put("rptTcxyCompanySoftwareCopyright", rptTcxyCompanySoftwareCopyright);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttcxycompanysoftwarecopyright:save")
    @ApiOperation("")
    public R save(@RequestBody RptTcxyCompanySoftwareCopyrightEntity rptTcxyCompanySoftwareCopyright){
			rptTcxyCompanySoftwareCopyrightService.insert(rptTcxyCompanySoftwareCopyright);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttcxycompanysoftwarecopyright:update")
    @ApiOperation("")
    public R update(@RequestBody RptTcxyCompanySoftwareCopyrightEntity rptTcxyCompanySoftwareCopyright){
			rptTcxyCompanySoftwareCopyrightService.updateById(rptTcxyCompanySoftwareCopyright);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttcxycompanysoftwarecopyright:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptTcxyCompanySoftwareCopyrightService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
