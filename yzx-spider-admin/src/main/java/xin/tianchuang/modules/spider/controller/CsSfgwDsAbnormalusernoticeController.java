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

import xin.tianchuang.modules.spider.entity.CsSfgwDsAbnormalusernoticeEntity;
import xin.tianchuang.modules.spider.service.CsSfgwDsAbnormalusernoticeService;
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
@RequestMapping("spider/cssfgwdsabnormalusernotice")
@Api("")
public class CsSfgwDsAbnormalusernoticeController {
    @Autowired
    private CsSfgwDsAbnormalusernoticeService csSfgwDsAbnormalusernoticeService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwdsabnormalusernotice:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwDsAbnormalusernoticeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwdsabnormalusernotice:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwDsAbnormalusernoticeEntity csSfgwDsAbnormalusernotice = csSfgwDsAbnormalusernoticeService.selectById(isinvalid);

        return R.ok().put("csSfgwDsAbnormalusernotice", csSfgwDsAbnormalusernotice);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwdsabnormalusernotice:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwDsAbnormalusernoticeEntity csSfgwDsAbnormalusernotice){
			csSfgwDsAbnormalusernoticeService.insert(csSfgwDsAbnormalusernotice);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwdsabnormalusernotice:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwDsAbnormalusernoticeEntity csSfgwDsAbnormalusernotice){
			csSfgwDsAbnormalusernoticeService.updateById(csSfgwDsAbnormalusernotice);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwdsabnormalusernotice:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwDsAbnormalusernoticeService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
