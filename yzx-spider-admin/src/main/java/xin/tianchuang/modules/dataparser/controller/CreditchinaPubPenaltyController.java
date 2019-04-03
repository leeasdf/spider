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

import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPenaltyService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-行政处罚
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinapubpenalty")
@Api(value = "", description = "")
public class CreditchinaPubPenaltyController {
    @Autowired
    private CreditchinaPubPenaltyService creditchinaPubPenaltyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinapubpenalty:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaPubPenaltyService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinapubpenalty:list")
    @ApiOperation(value = "", notes="")
    public R listByCfXdrMc(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaPubPenaltyService.queryPageByCfXdrMc(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinapubpenalty:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaPubPenaltyEntity creditchinaPubPenalty = creditchinaPubPenaltyService.selectById(id);

        return R.ok().put("creditchinaPubPenalty", creditchinaPubPenalty);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinapubpenalty:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaPubPenaltyEntity creditchinaPubPenalty){
			creditchinaPubPenaltyService.insert(creditchinaPubPenalty);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinapubpenalty:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaPubPenaltyEntity creditchinaPubPenalty){
			creditchinaPubPenaltyService.updateById(creditchinaPubPenalty);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinapubpenalty:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaPubPenaltyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
