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

import xin.tianchuang.modules.spider.entity.EntHighTechIndustrialEstateEntity;
import xin.tianchuang.modules.spider.service.EntHighTechIndustrialEstateService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:34
 */
@RestController
@RequestMapping("spider/enthightechindustrialestate")
@Api("")
public class EntHighTechIndustrialEstateController {
    @Autowired
    private EntHighTechIndustrialEstateService entHighTechIndustrialEstateService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechindustrialestate:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechIndustrialEstateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechindustrialestate:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechIndustrialEstateEntity entHighTechIndustrialEstate = entHighTechIndustrialEstateService.selectById(id);

        return R.ok().put("entHighTechIndustrialEstate", entHighTechIndustrialEstate);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechindustrialestate:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechIndustrialEstateEntity entHighTechIndustrialEstate){
			entHighTechIndustrialEstateService.insert(entHighTechIndustrialEstate);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechindustrialestate:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechIndustrialEstateEntity entHighTechIndustrialEstate){
			entHighTechIndustrialEstateService.updateById(entHighTechIndustrialEstate);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechindustrialestate:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechIndustrialEstateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
