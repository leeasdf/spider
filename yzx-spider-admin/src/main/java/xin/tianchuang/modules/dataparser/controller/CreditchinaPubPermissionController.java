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

import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPermissionEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPermissionService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 信用中国-行政许可
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinapubpermission")
@Api(value = "", description = "")
public class CreditchinaPubPermissionController {
    @Autowired
    private CreditchinaPubPermissionService creditchinaPubPermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinapubpermission:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaPubPermissionService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:creditchinapubpermission:list")
    @ApiOperation(value = "", notes="")
    public R listByXkXdr(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaPubPermissionService.queryPageByXkXdr(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinapubpermission:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaPubPermissionEntity creditchinaPubPermission = creditchinaPubPermissionService.selectById(id);

        return R.ok().put("creditchinaPubPermission", creditchinaPubPermission);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinapubpermission:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaPubPermissionEntity creditchinaPubPermission){
			creditchinaPubPermissionService.insert(creditchinaPubPermission);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinapubpermission:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaPubPermissionEntity creditchinaPubPermission){
			creditchinaPubPermissionService.updateById(creditchinaPubPermission);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinapubpermission:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaPubPermissionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
