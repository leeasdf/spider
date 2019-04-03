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

import xin.tianchuang.modules.spider.entity.CsSfgwAicInfoetailEntity;
import xin.tianchuang.modules.spider.service.CsSfgwAicInfoetailService;
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
@RequestMapping("spider/cssfgwaicinfoetail")
@Api("")
public class CsSfgwAicInfoetailController {
    @Autowired
    private CsSfgwAicInfoetailService csSfgwAicInfoetailService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:cssfgwaicinfoetail:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = csSfgwAicInfoetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{isinvalid}")
    @RequiresPermissions("spider:cssfgwaicinfoetail:info")
    @ApiOperation("")
    public R info(@PathVariable("isinvalid") Integer isinvalid){
			CsSfgwAicInfoetailEntity csSfgwAicInfoetail = csSfgwAicInfoetailService.selectById(isinvalid);

        return R.ok().put("csSfgwAicInfoetail", csSfgwAicInfoetail);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:cssfgwaicinfoetail:save")
    @ApiOperation("")
    public R save(@RequestBody CsSfgwAicInfoetailEntity csSfgwAicInfoetail){
			csSfgwAicInfoetailService.insert(csSfgwAicInfoetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:cssfgwaicinfoetail:update")
    @ApiOperation("")
    public R update(@RequestBody CsSfgwAicInfoetailEntity csSfgwAicInfoetail){
			csSfgwAicInfoetailService.updateById(csSfgwAicInfoetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:cssfgwaicinfoetail:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] isinvalids){
			csSfgwAicInfoetailService.deleteBatchIds(Arrays.asList(isinvalids));

        return R.ok();
    }

}
