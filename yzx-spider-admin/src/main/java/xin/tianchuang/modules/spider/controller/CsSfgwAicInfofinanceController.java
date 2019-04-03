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

import xin.tianchuang.modules.spider.entity.CsSfgwAicInfofinanceEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInfofinanceService;
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
@RequestMapping("spider/cssfgwaicinfofinance")
@Api("")
public class CsSfgwAicInfofinanceController {
    @Autowired
    private CsSfgwAicInfofinanceService csSfgwAicInfofinanceService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwaicinfofinance:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwAicInfofinanceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwaicinfofinance:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwAicInfofinanceEntity csSfgwAicInfofinance = csSfgwAicInfofinanceService.selectById(isinvalid);

        return R.ok().put("csSfgwAicInfofinance", csSfgwAicInfofinance);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwaicinfofinance:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwAicInfofinanceEntity csSfgwAicInfofinance){
			csSfgwAicInfofinanceService.insert(csSfgwAicInfofinance);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwaicinfofinance:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwAicInfofinanceEntity csSfgwAicInfofinance){
			csSfgwAicInfofinanceService.updateById(csSfgwAicInfofinance);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwaicinfofinance:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwAicInfofinanceService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
