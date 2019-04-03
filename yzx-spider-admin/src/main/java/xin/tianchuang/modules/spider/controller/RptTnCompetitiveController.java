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

import xin.tianchuang.modules.spider.entity.RptTnCompetitiveEntity;
import xin.tianchuang.modules.spider.service.RptTnCompetitiveService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-竞品信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:45
 */
@RestController
@RequestMapping("spider/rpttncompetitive")
@Api(value = "", description = "")
public class RptTnCompetitiveController {
    @Autowired
    private RptTnCompetitiveService rptTnCompetitiveService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttncompetitive:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnCompetitiveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttncompetitive:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnCompetitiveEntity rptTnCompetitive = rptTnCompetitiveService.selectById(id);

        return R.ok().put("rptTnCompetitive", rptTnCompetitive);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttncompetitive:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnCompetitiveEntity rptTnCompetitive){
			rptTnCompetitiveService.insert(rptTnCompetitive);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttncompetitive:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnCompetitiveEntity rptTnCompetitive){
			rptTnCompetitiveService.updateById(rptTnCompetitive);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttncompetitive:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnCompetitiveService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
