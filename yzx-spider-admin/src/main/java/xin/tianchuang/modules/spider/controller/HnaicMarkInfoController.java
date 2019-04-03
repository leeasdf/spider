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

import xin.tianchuang.modules.spider.entity.HnaicMarkInfoEntity;
import xin.tianchuang.modules.spider.service.HnaicMarkInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 *  湖南省工商局-商标公告
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-18 09:09:38
 */
@RestController
@RequestMapping("spider/hnaicmarkinfo")
@Api(value = "", description = "")
public class HnaicMarkInfoController {
    @Autowired
    private HnaicMarkInfoService hnaicMarkInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:hnaicmarkinfo:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hnaicMarkInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:hnaicmarkinfo:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			HnaicMarkInfoEntity hnaicMarkInfo = hnaicMarkInfoService.selectById(id);

        return R.ok().put("hnaicMarkInfo", hnaicMarkInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:hnaicmarkinfo:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody HnaicMarkInfoEntity hnaicMarkInfo){
			hnaicMarkInfoService.insert(hnaicMarkInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:hnaicmarkinfo:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody HnaicMarkInfoEntity hnaicMarkInfo){
			hnaicMarkInfoService.updateById(hnaicMarkInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:hnaicmarkinfo:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			hnaicMarkInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
