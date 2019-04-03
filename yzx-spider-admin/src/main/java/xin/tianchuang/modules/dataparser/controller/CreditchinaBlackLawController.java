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

import xin.tianchuang.modules.dataparser.entity.CreditchinaBlackLawEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaBlackLawService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-黑名单-最高法
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
@RestController
@RequestMapping("dataparser/creditchinablacklaw")
@Api(value = "", description = "")
public class CreditchinaBlackLawController {
    @Autowired
    private CreditchinaBlackLawService creditchinaBlackLawService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinablacklaw:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaBlackLawService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinablacklaw:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaBlackLawEntity creditchinaBlackLaw = creditchinaBlackLawService.selectById(id);

        return R.ok().put("creditchinaBlackLaw", creditchinaBlackLaw);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinablacklaw:list")
    @ApiOperation(value = "", notes="")
    public R listByDishonestName(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaBlackLawService.queryPageByDishonestName(params);
        return R.ok().put("page", page);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinablacklaw:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaBlackLawEntity creditchinaBlackLaw){
			creditchinaBlackLawService.insert(creditchinaBlackLaw);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinablacklaw:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaBlackLawEntity creditchinaBlackLaw){
			creditchinaBlackLawService.updateById(creditchinaBlackLaw);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinablacklaw:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaBlackLawService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
