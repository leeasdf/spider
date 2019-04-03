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

import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusPenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaFocusPenaltyService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-重点关注名单-证监会
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-16 14:58:55
 */
@RestController
@RequestMapping("dataparser/creditchinafocuspenalty")
@Api(value = "", description = "")
public class CreditchinaFocusPenaltyController {
    @Autowired
    private CreditchinaFocusPenaltyService creditchinaFocusPenaltyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaFocusPenaltyService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:list")
    @ApiOperation(value = "", notes="")
    public R listByPunishmentObject(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaFocusPenaltyService.queryPageByPunishmentObject(params);

        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaFocusPenaltyEntity creditchinaFocusPenalty = creditchinaFocusPenaltyService.selectById(id);

        return R.ok().put("creditchinaFocusPenalty", creditchinaFocusPenalty);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaFocusPenaltyEntity creditchinaFocusPenalty){
			creditchinaFocusPenaltyService.insert(creditchinaFocusPenalty);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaFocusPenaltyEntity creditchinaFocusPenalty){
			creditchinaFocusPenaltyService.updateById(creditchinaFocusPenalty);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinafocuspenalty:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaFocusPenaltyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
