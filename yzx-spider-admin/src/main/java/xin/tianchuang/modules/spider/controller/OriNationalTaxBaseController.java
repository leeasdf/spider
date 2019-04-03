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

import xin.tianchuang.modules.spider.entity.OriNationalTaxBaseEntity;
import xin.tianchuang.modules.spider.service.OriNationalTaxBaseService;
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
@RequestMapping("spider/orinationaltaxbase")
@Api("")
public class OriNationalTaxBaseController {
    @Autowired
    private OriNationalTaxBaseService oriNationalTaxBaseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:orinationaltaxbase:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oriNationalTaxBaseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:orinationaltaxbase:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			OriNationalTaxBaseEntity oriNationalTaxBase = oriNationalTaxBaseService.selectById(id);

        return R.ok().put("oriNationalTaxBase", oriNationalTaxBase);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:orinationaltaxbase:save")
    @ApiOperation("")
    public R save(@RequestBody OriNationalTaxBaseEntity oriNationalTaxBase){
			oriNationalTaxBaseService.insert(oriNationalTaxBase);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:orinationaltaxbase:update")
    @ApiOperation("")
    public R update(@RequestBody OriNationalTaxBaseEntity oriNationalTaxBase){
			oriNationalTaxBaseService.updateById(oriNationalTaxBase);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:orinationaltaxbase:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			oriNationalTaxBaseService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
