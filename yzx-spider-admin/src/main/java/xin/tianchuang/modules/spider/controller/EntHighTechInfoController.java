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

import xin.tianchuang.modules.spider.entity.EntHighTechInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechInfoService;
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
@RequestMapping("spider/enthightechinfo")
@Api("")
public class EntHighTechInfoController {
    @Autowired
    private EntHighTechInfoService entHighTechInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechInfoEntity entHighTechInfo = entHighTechInfoService.selectById(id);

        return R.ok().put("entHighTechInfo", entHighTechInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechInfoEntity entHighTechInfo){
			entHighTechInfoService.insert(entHighTechInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechInfoEntity entHighTechInfo){
			entHighTechInfoService.updateById(entHighTechInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
