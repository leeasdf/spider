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

import xin.tianchuang.modules.spider.entity.EntHighTechPunishInfoEntity;
import xin.tianchuang.modules.spider.service.EntHighTechPunishInfoService;
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
@RequestMapping("spider/enthightechpunishinfo")
@Api("")
public class EntHighTechPunishInfoController {
    @Autowired
    private EntHighTechPunishInfoService entHighTechPunishInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechpunishinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechPunishInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechpunishinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechPunishInfoEntity entHighTechPunishInfo = entHighTechPunishInfoService.selectById(id);

        return R.ok().put("entHighTechPunishInfo", entHighTechPunishInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechpunishinfo:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechPunishInfoEntity entHighTechPunishInfo){
			entHighTechPunishInfoService.insert(entHighTechPunishInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechpunishinfo:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechPunishInfoEntity entHighTechPunishInfo){
			entHighTechPunishInfoService.updateById(entHighTechPunishInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechpunishinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechPunishInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
