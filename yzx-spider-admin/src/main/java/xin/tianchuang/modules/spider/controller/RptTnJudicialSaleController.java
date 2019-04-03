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

import xin.tianchuang.modules.spider.entity.RptTnJudicialSaleEntity;
import xin.tianchuang.modules.spider.service.RptTnJudicialSaleService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * tyc企业-司法拍卖信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-04 10:17:48
 */
@RestController
@RequestMapping("spider/rpttnjudicialsale")
@Api(value = "", description = "")
public class RptTnJudicialSaleController {
    @Autowired
    private RptTnJudicialSaleService rptTnJudicialSaleService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttnjudicialsale:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnJudicialSaleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttnjudicialsale:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnJudicialSaleEntity rptTnJudicialSale = rptTnJudicialSaleService.selectById(id);

        return R.ok().put("rptTnJudicialSale", rptTnJudicialSale);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttnjudicialsale:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnJudicialSaleEntity rptTnJudicialSale){
			rptTnJudicialSaleService.insert(rptTnJudicialSale);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttnjudicialsale:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnJudicialSaleEntity rptTnJudicialSale){
			rptTnJudicialSaleService.updateById(rptTnJudicialSale);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttnjudicialsale:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnJudicialSaleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
