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

import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusGszjEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaFocusGszjService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-重点关注名单-工商总局
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 11:01:12
 */
@RestController
@RequestMapping("dataparser/creditchinafocusgszj")
@Api(value = "", description = "")
public class CreditchinaFocusGszjController {
    @Autowired
    private CreditchinaFocusGszjService creditchinaFocusGszjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinafocusgszj:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaFocusGszjService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinafocusgszj:list")
    @ApiOperation(value = "", notes="")
    public R listByEnterpriseName(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaFocusGszjService.queryPageByEnterpriseName(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinafocusgszj:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaFocusGszjEntity creditchinaFocusGszj = creditchinaFocusGszjService.selectById(id);

        return R.ok().put("creditchinaFocusGszj", creditchinaFocusGszj);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinafocusgszj:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaFocusGszjEntity creditchinaFocusGszj){
			creditchinaFocusGszjService.insert(creditchinaFocusGszj);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinafocusgszj:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaFocusGszjEntity creditchinaFocusGszj){
			creditchinaFocusGszjService.updateById(creditchinaFocusGszj);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinafocusgszj:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaFocusGszjService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
