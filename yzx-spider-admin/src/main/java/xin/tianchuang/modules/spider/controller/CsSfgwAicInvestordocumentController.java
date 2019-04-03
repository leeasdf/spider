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

import xin.tianchuang.modules.spider.entity.CsSfgwAicInvestordocumentEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInvestordocumentService;
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
@RequestMapping("spider/cssfgwaicinvestordocument")
@Api("")
public class CsSfgwAicInvestordocumentController {
    @Autowired
    private CsSfgwAicInvestordocumentService csSfgwAicInvestordocumentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwaicinvestordocument:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwAicInvestordocumentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwaicinvestordocument:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwAicInvestordocumentEntity csSfgwAicInvestordocument = csSfgwAicInvestordocumentService.selectById(isinvalid);

        return R.ok().put("csSfgwAicInvestordocument", csSfgwAicInvestordocument);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwaicinvestordocument:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwAicInvestordocumentEntity csSfgwAicInvestordocument){
			csSfgwAicInvestordocumentService.insert(csSfgwAicInvestordocument);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwaicinvestordocument:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwAicInvestordocumentEntity csSfgwAicInvestordocument){
			csSfgwAicInvestordocumentService.updateById(csSfgwAicInvestordocument);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwaicinvestordocument:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwAicInvestordocumentService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
