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

import xin.tianchuang.modules.spider.entity.HnEntEnvCreditEntity;
import xin.tianchuang.modules.spider.service.HnEntEnvCreditService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 *  湖南省企业环境信用评价信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-12 12:12:48
 */
@RestController
@RequestMapping("spider/hnentenvcredit")
@Api(value = "", description = "")
public class HnEntEnvCreditController {
    @Autowired
    private HnEntEnvCreditService hnEntEnvCreditService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:hnentenvcredit:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hnEntEnvCreditService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:hnentenvcredit:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			HnEntEnvCreditEntity hnEntEnvCredit = hnEntEnvCreditService.selectById(id);

        return R.ok().put("hnEntEnvCredit", hnEntEnvCredit);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:hnentenvcredit:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody HnEntEnvCreditEntity hnEntEnvCredit){
			hnEntEnvCreditService.insert(hnEntEnvCredit);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:hnentenvcredit:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody HnEntEnvCreditEntity hnEntEnvCredit){
			hnEntEnvCreditService.updateById(hnEntEnvCredit);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:hnentenvcredit:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			hnEntEnvCreditService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
