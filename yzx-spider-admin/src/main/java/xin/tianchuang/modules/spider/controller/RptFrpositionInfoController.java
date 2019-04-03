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

import xin.tianchuang.modules.spider.entity.RptFrpositionInfoEntity;
import xin.tianchuang.modules.spider.service.RptFrpositionInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:37
 */
@RestController
@RequestMapping("spider/rptfrpositioninfo")
@Api("")
public class RptFrpositionInfoController {
    @Autowired
    private RptFrpositionInfoService rptFrpositionInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptfrpositioninfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptFrpositionInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptfrpositioninfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptFrpositionInfoEntity rptFrpositionInfo = rptFrpositionInfoService.selectById(id);

        return R.ok().put("rptFrpositionInfo", rptFrpositionInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptfrpositioninfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptFrpositionInfoEntity rptFrpositionInfo){
			rptFrpositionInfoService.insert(rptFrpositionInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptfrpositioninfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptFrpositionInfoEntity rptFrpositionInfo){
			rptFrpositionInfoService.updateById(rptFrpositionInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptfrpositioninfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptFrpositionInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
