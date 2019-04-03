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

import xin.tianchuang.modules.spider.entity.RptTrademarkInfoEntity;
import xin.tianchuang.modules.spider.service.RptTrademarkInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:40
 */
@RestController
@RequestMapping("spider/rpttrademarkinfo")
@Api("")
public class RptTrademarkInfoController {
    @Autowired
    private RptTrademarkInfoService rptTrademarkInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:rpttrademarkinfo:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTrademarkInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:rpttrademarkinfo:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			RptTrademarkInfoEntity rptTrademarkInfo = rptTrademarkInfoService.selectById(id);

        return R.ok().put("rptTrademarkInfo", rptTrademarkInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:rpttrademarkinfo:save")
    @ApiOperation("")
    public R save(@RequestBody RptTrademarkInfoEntity rptTrademarkInfo){
			rptTrademarkInfoService.insert(rptTrademarkInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:rpttrademarkinfo:update")
    @ApiOperation("")
    public R update(@RequestBody RptTrademarkInfoEntity rptTrademarkInfo){
			rptTrademarkInfoService.updateById(rptTrademarkInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:rpttrademarkinfo:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			rptTrademarkInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
