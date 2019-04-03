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

import xin.tianchuang.modules.spider.entity.EnterpriseArrearageEntity;
import xin.tianchuang.modules.spider.service.EnterpriseArrearageService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:35
 */
@RestController
@RequestMapping("spider/enterprisearrearage")
@Api("")
public class EnterpriseArrearageController {
    @Autowired
    private EnterpriseArrearageService enterpriseArrearageService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enterprisearrearage:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterpriseArrearageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enterprisearrearage:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EnterpriseArrearageEntity enterpriseArrearage = enterpriseArrearageService.selectById(id);

        return R.ok().put("enterpriseArrearage", enterpriseArrearage);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enterprisearrearage:save")
    @ApiOperation("")
    public R save(@RequestBody EnterpriseArrearageEntity enterpriseArrearage){
			enterpriseArrearageService.insert(enterpriseArrearage);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enterprisearrearage:update")
    @ApiOperation("")
    public R update(@RequestBody EnterpriseArrearageEntity enterpriseArrearage){
			enterpriseArrearageService.updateById(enterpriseArrearage);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enterprisearrearage:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			enterpriseArrearageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
