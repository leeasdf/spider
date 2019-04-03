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

import xin.tianchuang.modules.spider.entity.RptTnInvestEventEntity;
import xin.tianchuang.modules.spider.service.RptTnInvestEventService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-投资事件
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:46
 */
@RestController
@RequestMapping("spider/rpttninvestevent")
@Api(value = "", description = "")
public class RptTnInvestEventController {
    @Autowired
    private RptTnInvestEventService rptTnInvestEventService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttninvestevent:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnInvestEventService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttninvestevent:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnInvestEventEntity rptTnInvestEvent = rptTnInvestEventService.selectById(id);

        return R.ok().put("rptTnInvestEvent", rptTnInvestEvent);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttninvestevent:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnInvestEventEntity rptTnInvestEvent){
			rptTnInvestEventService.insert(rptTnInvestEvent);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttninvestevent:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnInvestEventEntity rptTnInvestEvent){
			rptTnInvestEventService.updateById(rptTnInvestEvent);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttninvestevent:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnInvestEventService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
