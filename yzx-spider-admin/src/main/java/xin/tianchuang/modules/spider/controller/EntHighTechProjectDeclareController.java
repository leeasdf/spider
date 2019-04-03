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

import xin.tianchuang.modules.spider.entity.EntHighTechProjectDeclareEntity;
import xin.tianchuang.modules.spider.service.EntHighTechProjectDeclareService;
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
@RequestMapping("spider/enthightechprojectdeclare")
@Api("")
public class EntHighTechProjectDeclareController {
    @Autowired
    private EntHighTechProjectDeclareService entHighTechProjectDeclareService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechprojectdeclare:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechProjectDeclareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechprojectdeclare:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechProjectDeclareEntity entHighTechProjectDeclare = entHighTechProjectDeclareService.selectById(id);

        return R.ok().put("entHighTechProjectDeclare", entHighTechProjectDeclare);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechprojectdeclare:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechProjectDeclareEntity entHighTechProjectDeclare){
			entHighTechProjectDeclareService.insert(entHighTechProjectDeclare);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechprojectdeclare:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechProjectDeclareEntity entHighTechProjectDeclare){
			entHighTechProjectDeclareService.updateById(entHighTechProjectDeclare);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechprojectdeclare:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechProjectDeclareService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
