package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.entity.CsSfgwAicEJyycmlxxEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicEJyycmlxxService;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:33
 */
@RestController
@RequestMapping("spider/cssfgwaicejyycmlxx")
@Api("")
public class CsSfgwAicEJyycmlxxController {
    @Autowired
    private CsSfgwAicEJyycmlxxService csSfgwAicEJyycmlxxService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwaicejyycmlxx:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwAicEJyycmlxxService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwaicejyycmlxx:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwAicEJyycmlxxEntity csSfgwAicEJyycmlxx = csSfgwAicEJyycmlxxService.selectById(isinvalid);

        return R.ok().put("csSfgwAicEJyycmlxx", csSfgwAicEJyycmlxx);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwaicejyycmlxx:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwAicEJyycmlxxEntity csSfgwAicEJyycmlxx){
			csSfgwAicEJyycmlxxService.insert(csSfgwAicEJyycmlxx);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwaicejyycmlxx:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwAicEJyycmlxxEntity csSfgwAicEJyycmlxx){
			csSfgwAicEJyycmlxxService.updateById(csSfgwAicEJyycmlxx);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwaicejyycmlxx:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwAicEJyycmlxxService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
