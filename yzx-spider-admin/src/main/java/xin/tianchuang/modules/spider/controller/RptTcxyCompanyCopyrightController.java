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

import xin.tianchuang.modules.spider.entity.RptTcxyCompanyCopyrightEntity;
import xin.tianchuang.modules.spider.service.RptTcxyCompanyCopyrightService;
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
@RequestMapping("spider/rpttcxycompanycopyright")
@Api("")
public class RptTcxyCompanyCopyrightController {
    @Autowired
    private RptTcxyCompanyCopyrightService rptTcxyCompanyCopyrightService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttcxycompanycopyright:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTcxyCompanyCopyrightService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttcxycompanycopyright:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptTcxyCompanyCopyrightEntity rptTcxyCompanyCopyright = rptTcxyCompanyCopyrightService.selectById(id);

        return R.ok().put("rptTcxyCompanyCopyright", rptTcxyCompanyCopyright);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttcxycompanycopyright:save")
    @ApiOperation("")
    public R save(@RequestBody RptTcxyCompanyCopyrightEntity rptTcxyCompanyCopyright){
			rptTcxyCompanyCopyrightService.insert(rptTcxyCompanyCopyright);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttcxycompanycopyright:update")
    @ApiOperation("")
    public R update(@RequestBody RptTcxyCompanyCopyrightEntity rptTcxyCompanyCopyright){
			rptTcxyCompanyCopyrightService.updateById(rptTcxyCompanyCopyright);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttcxycompanycopyright:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptTcxyCompanyCopyrightService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
