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

import xin.tianchuang.modules.spider.entity.EntHighTechFaithLoseEntity;
import xin.tianchuang.modules.spider.service.EntHighTechFaithLoseService;
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
@RequestMapping("spider/enthightechfaithlose")
@Api("")
public class EntHighTechFaithLoseController {
    @Autowired
    private EntHighTechFaithLoseService entHighTechFaithLoseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enthightechfaithlose:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entHighTechFaithLoseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enthightechfaithlose:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EntHighTechFaithLoseEntity entHighTechFaithLose = entHighTechFaithLoseService.selectById(id);

        return R.ok().put("entHighTechFaithLose", entHighTechFaithLose);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enthightechfaithlose:save")
    @ApiOperation("")
    public R save(@RequestBody EntHighTechFaithLoseEntity entHighTechFaithLose){
			entHighTechFaithLoseService.insert(entHighTechFaithLose);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enthightechfaithlose:update")
    @ApiOperation("")
    public R update(@RequestBody EntHighTechFaithLoseEntity entHighTechFaithLose){
			entHighTechFaithLoseService.updateById(entHighTechFaithLose);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enthightechfaithlose:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			entHighTechFaithLoseService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
