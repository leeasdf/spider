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

import xin.tianchuang.modules.spider.entity.RptTnFinanceEntity;
import xin.tianchuang.modules.spider.service.RptTnFinanceService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-融资历史
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 14:24:47
 */
@RestController
@RequestMapping("spider/rpttnfinance")
@Api(value = "", description = "")
public class RptTnFinanceController {
    @Autowired
    private RptTnFinanceService rptTnFinanceService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnfinance:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnFinanceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnfinance:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnFinanceEntity rptTnFinance = rptTnFinanceService.selectById(id);

        return R.ok().put("rptTnFinance", rptTnFinance);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnfinance:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnFinanceEntity rptTnFinance){
			rptTnFinanceService.insert(rptTnFinance);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnfinance:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnFinanceEntity rptTnFinance){
			rptTnFinanceService.updateById(rptTnFinance);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnfinance:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnFinanceService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
