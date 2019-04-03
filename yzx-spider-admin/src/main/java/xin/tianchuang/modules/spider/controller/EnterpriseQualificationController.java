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

import xin.tianchuang.modules.spider.entity.EnterpriseQualificationEntity;
import xin.tianchuang.modules.spider.service.EnterpriseQualificationService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/enterprisequalification")
@Api("")
public class EnterpriseQualificationController {
    @Autowired
    private EnterpriseQualificationService enterpriseQualificationService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enterprisequalification:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterpriseQualificationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{enterpriseQualificationId}")
    @RequiresPermissions("spider:enterprisequalification:info")
    @ApiOperation("")
    public R info(@PathVariable("enterpriseQualificationId") Integer enterpriseQualificationId){
			EnterpriseQualificationEntity enterpriseQualification = enterpriseQualificationService.selectById(enterpriseQualificationId);

        return R.ok().put("enterpriseQualification", enterpriseQualification);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enterprisequalification:save")
    @ApiOperation("")
    public R save(@RequestBody EnterpriseQualificationEntity enterpriseQualification){
			enterpriseQualificationService.insert(enterpriseQualification);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enterprisequalification:update")
    @ApiOperation("")
    public R update(@RequestBody EnterpriseQualificationEntity enterpriseQualification){
			enterpriseQualificationService.updateById(enterpriseQualification);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enterprisequalification:delete")
    @ApiOperation("")
    public R delete(@RequestBody Integer[] enterpriseQualificationIds){
			enterpriseQualificationService.deleteBatchIds(Arrays.asList(enterpriseQualificationIds));

        return R.ok();
    }

}
