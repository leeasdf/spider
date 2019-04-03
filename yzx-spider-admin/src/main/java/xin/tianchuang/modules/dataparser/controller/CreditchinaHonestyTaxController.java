package xin.tianchuang.modules.dataparser.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.annotation.SysLog;

import xin.tianchuang.modules.dataparser.entity.CreditchinaHonestyTaxEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaHonestyTaxService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-守信红名单
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinahonestytax")
@Api(value = "", description = "")
public class CreditchinaHonestyTaxController {
    @Autowired
    private CreditchinaHonestyTaxService creditchinaHonestyTaxService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinahonestytax:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaHonestyTaxService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinahonestytax:list")
    @ApiOperation(value = "", notes="")
    public R listByTaxName(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaHonestyTaxService.queryPageByTaxName(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinahonestytax:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaHonestyTaxEntity creditchinaHonestyTax = creditchinaHonestyTaxService.selectById(id);

        return R.ok().put("creditchinaHonestyTax", creditchinaHonestyTax);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinahonestytax:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaHonestyTaxEntity creditchinaHonestyTax){
			creditchinaHonestyTaxService.insert(creditchinaHonestyTax);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinahonestytax:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaHonestyTaxEntity creditchinaHonestyTax){
			creditchinaHonestyTaxService.updateById(creditchinaHonestyTax);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinahonestytax:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaHonestyTaxService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
