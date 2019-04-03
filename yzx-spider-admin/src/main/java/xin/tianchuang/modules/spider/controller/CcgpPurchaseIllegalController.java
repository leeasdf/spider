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

import xin.tianchuang.modules.spider.entity.CcgpPurchaseIllegalEntity;
import xin.tianchuang.modules.spider.service.CcgpPurchaseIllegalService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 中国政府采购网-采购严重违法失信行为记录
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-21 14:10:47
 */
@RestController
@RequestMapping("spider/ccgppurchaseillegal")
@Api(value = "", description = "")
public class CcgpPurchaseIllegalController {
    @Autowired
    private CcgpPurchaseIllegalService ccgpPurchaseIllegalService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:ccgppurchaseillegal:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ccgpPurchaseIllegalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:ccgppurchaseillegal:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CcgpPurchaseIllegalEntity ccgpPurchaseIllegal = ccgpPurchaseIllegalService.selectById(id);

        return R.ok().put("ccgpPurchaseIllegal", ccgpPurchaseIllegal);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:ccgppurchaseillegal:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CcgpPurchaseIllegalEntity ccgpPurchaseIllegal){
			ccgpPurchaseIllegalService.insert(ccgpPurchaseIllegal);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:ccgppurchaseillegal:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CcgpPurchaseIllegalEntity ccgpPurchaseIllegal){
			ccgpPurchaseIllegalService.updateById(ccgpPurchaseIllegal);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:ccgppurchaseillegal:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			ccgpPurchaseIllegalService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
