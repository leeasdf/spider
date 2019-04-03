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

import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-信用类型中间表(路由表)
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinacredittype")
@Api(value = "", description = "")
public class CreditchinaCreditTypeController {
    @Autowired
    private CreditchinaCreditTypeService creditchinaCreditTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinacredittype:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaCreditTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinacredittype:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaCreditTypeEntity creditchinaCreditType = creditchinaCreditTypeService.selectById(id);

        return R.ok().put("creditchinaCreditType", creditchinaCreditType);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinacredittype:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaCreditTypeEntity creditchinaCreditType){
			creditchinaCreditTypeService.insert(creditchinaCreditType);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinacredittype:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaCreditTypeEntity creditchinaCreditType){
			creditchinaCreditTypeService.updateById(creditchinaCreditType);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinacredittype:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaCreditTypeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
