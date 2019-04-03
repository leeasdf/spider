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

import xin.tianchuang.modules.spider.entity.OriEnterpriseOperatingExceptionEntity;
import xin.tianchuang.modules.spider.service.OriEnterpriseOperatingExceptionService;
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
@RequestMapping("spider/orienterpriseoperatingexception")
@Api("")
public class OriEnterpriseOperatingExceptionController {
    @Autowired
    private OriEnterpriseOperatingExceptionService oriEnterpriseOperatingExceptionService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:orienterpriseoperatingexception:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = oriEnterpriseOperatingExceptionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:orienterpriseoperatingexception:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			OriEnterpriseOperatingExceptionEntity oriEnterpriseOperatingException = oriEnterpriseOperatingExceptionService.selectById(id);

        return R.ok().put("oriEnterpriseOperatingException", oriEnterpriseOperatingException);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:orienterpriseoperatingexception:save")
    @ApiOperation("")
    public R save(@RequestBody OriEnterpriseOperatingExceptionEntity oriEnterpriseOperatingException){
			oriEnterpriseOperatingExceptionService.insert(oriEnterpriseOperatingException);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:orienterpriseoperatingexception:update")
    @ApiOperation("")
    public R update(@RequestBody OriEnterpriseOperatingExceptionEntity oriEnterpriseOperatingException){
			oriEnterpriseOperatingExceptionService.updateById(oriEnterpriseOperatingException);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:orienterpriseoperatingexception:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			oriEnterpriseOperatingExceptionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
