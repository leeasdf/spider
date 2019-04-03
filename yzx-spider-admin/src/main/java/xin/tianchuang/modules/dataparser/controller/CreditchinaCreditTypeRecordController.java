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

import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeRecordEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeRecordService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-信用类型中间表(路由记录表)
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinacredittyperecord")
@Api(value = "", description = "")
public class CreditchinaCreditTypeRecordController {
    @Autowired
    private CreditchinaCreditTypeRecordService creditchinaCreditTypeRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinacredittyperecord:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaCreditTypeRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinacredittyperecord:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaCreditTypeRecordEntity creditchinaCreditTypeRecord = creditchinaCreditTypeRecordService.selectById(id);

        return R.ok().put("creditchinaCreditTypeRecord", creditchinaCreditTypeRecord);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinacredittyperecord:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaCreditTypeRecordEntity creditchinaCreditTypeRecord){
			creditchinaCreditTypeRecordService.insert(creditchinaCreditTypeRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinacredittyperecord:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaCreditTypeRecordEntity creditchinaCreditTypeRecord){
			creditchinaCreditTypeRecordService.updateById(creditchinaCreditTypeRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinacredittyperecord:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaCreditTypeRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
