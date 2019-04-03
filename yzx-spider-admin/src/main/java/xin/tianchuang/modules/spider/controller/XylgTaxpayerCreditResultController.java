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

import xin.tianchuang.modules.spider.entity.XylgTaxpayerCreditResultEntity;
import xin.tianchuang.modules.spider.service.XylgTaxpayerCreditResultService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:40
 */
@RestController
@RequestMapping("spider/xylgtaxpayercreditresult")
@Api("")
public class XylgTaxpayerCreditResultController {
    @Autowired
    private XylgTaxpayerCreditResultService xylgTaxpayerCreditResultService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:xylgtaxpayercreditresult:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = xylgTaxpayerCreditResultService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:xylgtaxpayercreditresult:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			XylgTaxpayerCreditResultEntity xylgTaxpayerCreditResult = xylgTaxpayerCreditResultService.selectById(id);

        return R.ok().put("xylgTaxpayerCreditResult", xylgTaxpayerCreditResult);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:xylgtaxpayercreditresult:save")
    @ApiOperation("")
    public R save(@RequestBody XylgTaxpayerCreditResultEntity xylgTaxpayerCreditResult){
			xylgTaxpayerCreditResultService.insert(xylgTaxpayerCreditResult);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:xylgtaxpayercreditresult:update")
    @ApiOperation("")
    public R update(@RequestBody XylgTaxpayerCreditResultEntity xylgTaxpayerCreditResult){
			xylgTaxpayerCreditResultService.updateById(xylgTaxpayerCreditResult);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:xylgtaxpayercreditresult:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids){
			xylgTaxpayerCreditResultService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
