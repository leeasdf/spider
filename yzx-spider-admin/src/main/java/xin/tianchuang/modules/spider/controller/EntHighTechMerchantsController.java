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

import xin.tianchuang.modules.spider.entity.EntHighTechMerchantsEntity;
import xin.tianchuang.modules.spider.service.EntHighTechMerchantsService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:35
 */
@RestController
@RequestMapping("spider/enthightechmerchants")
@Api("")
public class EntHighTechMerchantsController {
    @Autowired
    private EntHighTechMerchantsService entHighTechMerchantsService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechmerchants:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechMerchantsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechmerchants:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechMerchantsEntity entHighTechMerchants = entHighTechMerchantsService.selectById(id);

        return R.ok().put("entHighTechMerchants", entHighTechMerchants);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechmerchants:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechMerchantsEntity entHighTechMerchants){
			entHighTechMerchantsService.insert(entHighTechMerchants);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechmerchants:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechMerchantsEntity entHighTechMerchants){
			entHighTechMerchantsService.updateById(entHighTechMerchants);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechmerchants:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechMerchantsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
