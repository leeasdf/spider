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

import xin.tianchuang.modules.spider.entity.OriAdministrativePenaltyEntity;
import xin.tianchuang.modules.spider.service.OriAdministrativePenaltyService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/oriadministrativepenalty")
@Api("")
public class OriAdministrativePenaltyController {
    @Autowired
    private OriAdministrativePenaltyService oriAdministrativePenaltyService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:oriadministrativepenalty:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oriAdministrativePenaltyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:oriadministrativepenalty:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			OriAdministrativePenaltyEntity oriAdministrativePenalty = oriAdministrativePenaltyService.selectById(id);

        return R.ok().put("oriAdministrativePenalty", oriAdministrativePenalty);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:oriadministrativepenalty:save")
    @ApiOperation("")
    public R save(@RequestBody OriAdministrativePenaltyEntity oriAdministrativePenalty){
			oriAdministrativePenaltyService.insert(oriAdministrativePenalty);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:oriadministrativepenalty:update")
    @ApiOperation("")
    public R update(@RequestBody OriAdministrativePenaltyEntity oriAdministrativePenalty){
			oriAdministrativePenaltyService.updateById(oriAdministrativePenalty);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:oriadministrativepenalty:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			oriAdministrativePenaltyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
