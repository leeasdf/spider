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

import xin.tianchuang.modules.spider.entity.ApiLogEntity;
import xin.tianchuang.modules.spider.service.ApiLogService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:33
 */
@RestController
@RequestMapping("spider/apilog")
@Api("")
public class ApiLogController {
    @Autowired
    private ApiLogService apiLogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:apilog:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = apiLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:apilog:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			ApiLogEntity apiLog = apiLogService.selectById(id);

        return R.ok().put("apiLog", apiLog);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:apilog:save")
    @ApiOperation("")
    public R save(@RequestBody ApiLogEntity apiLog){
			apiLogService.insert(apiLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:apilog:update")
    @ApiOperation("")
    public R update(@RequestBody ApiLogEntity apiLog){
			apiLogService.updateById(apiLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:apilog:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			apiLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
