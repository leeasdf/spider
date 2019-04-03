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

import xin.tianchuang.modules.spider.entity.RptCopyrightInfoEntity;
import xin.tianchuang.modules.spider.service.RptCopyrightInfoService;
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
@RequestMapping("spider/rptcopyrightinfo")
@Api("")
public class RptCopyrightInfoController {
    @Autowired
    private RptCopyrightInfoService rptCopyrightInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rptcopyrightinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptCopyrightInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rptcopyrightinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptCopyrightInfoEntity rptCopyrightInfo = rptCopyrightInfoService.selectById(id);

        return R.ok().put("rptCopyrightInfo", rptCopyrightInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rptcopyrightinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptCopyrightInfoEntity rptCopyrightInfo){
			rptCopyrightInfoService.insert(rptCopyrightInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rptcopyrightinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptCopyrightInfoEntity rptCopyrightInfo){
			rptCopyrightInfoService.updateById(rptCopyrightInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rptcopyrightinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptCopyrightInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
