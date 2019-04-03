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

import xin.tianchuang.modules.spider.entity.EntHighTechVerifyInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechVerifyInfoService;
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
@RequestMapping("spider/enthightechverifyinfo")
@Api("")
public class EntHighTechVerifyInfoController {
    @Autowired
    private EntHighTechVerifyInfoService entHighTechVerifyInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechverifyinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechVerifyInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechverifyinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechVerifyInfoEntity entHighTechVerifyInfo = entHighTechVerifyInfoService.selectById(id);

        return R.ok().put("entHighTechVerifyInfo", entHighTechVerifyInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechverifyinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechVerifyInfoEntity entHighTechVerifyInfo){
			entHighTechVerifyInfoService.insert(entHighTechVerifyInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechverifyinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechVerifyInfoEntity entHighTechVerifyInfo){
			entHighTechVerifyInfoService.updateById(entHighTechVerifyInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechverifyinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechVerifyInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
