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

import xin.tianchuang.modules.spider.entity.CsSfgwTaxInformationEntity;
import xin.tianchuang.modules.spider.service.CsSfgwTaxInformationService;
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
@RequestMapping("spider/cssfgwtaxinformation")
@Api("")
public class CsSfgwTaxInformationController {
    @Autowired
    private CsSfgwTaxInformationService csSfgwTaxInformationService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwtaxinformation:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwTaxInformationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwtaxinformation:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwTaxInformationEntity csSfgwTaxInformation = csSfgwTaxInformationService.selectById(isinvalid);

        return R.ok().put("csSfgwTaxInformation", csSfgwTaxInformation);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwtaxinformation:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwTaxInformationEntity csSfgwTaxInformation){
			csSfgwTaxInformationService.insert(csSfgwTaxInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwtaxinformation:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwTaxInformationEntity csSfgwTaxInformation){
			csSfgwTaxInformationService.updateById(csSfgwTaxInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwtaxinformation:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwTaxInformationService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
