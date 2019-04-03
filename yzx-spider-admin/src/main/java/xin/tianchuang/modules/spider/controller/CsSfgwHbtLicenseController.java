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

import xin.tianchuang.modules.spider.entity.CsSfgwHbtLicenseEntity;
import xin.tianchuang.modules.spider.service.CsSfgwHbtLicenseService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:34
 */
@RestController
@RequestMapping("spider/cssfgwhbtlicense")
@Api("")
public class CsSfgwHbtLicenseController {
    @Autowired
    private CsSfgwHbtLicenseService csSfgwHbtLicenseService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwhbtlicense:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwHbtLicenseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwhbtlicense:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwHbtLicenseEntity csSfgwHbtLicense = csSfgwHbtLicenseService.selectById(isinvalid);

        return R.ok().put("csSfgwHbtLicense", csSfgwHbtLicense);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwhbtlicense:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwHbtLicenseEntity csSfgwHbtLicense){
			csSfgwHbtLicenseService.insert(csSfgwHbtLicense);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwhbtlicense:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwHbtLicenseEntity csSfgwHbtLicense){
			csSfgwHbtLicenseService.updateById(csSfgwHbtLicense);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwhbtlicense:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwHbtLicenseService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
