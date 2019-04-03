package xin.tianchuang.modules.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.Map;

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
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.entity.RptTnPunishCreditchinaEntity;
import xin.tianchuang.modules.spider.service.RptTnPunishCreditchinaService;



/**
 * tyc行政处罚[工商局]
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-03 17:46:29
 */
@RestController
@RequestMapping("api/rpttnpunishcreditchina")
@Api(value = "", description = "")
public class RptTnPunishCreditchinaController {
    @Autowired
    private RptTnPunishCreditchinaService rptTnPunishCreditchinaService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("api:rpttnpunishcreditchina:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rptTnPunishCreditchinaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("api:rpttnpunishcreditchina:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			RptTnPunishCreditchinaEntity rptTnPunishCreditchina = rptTnPunishCreditchinaService.selectById(id);

        return R.ok().put("rptTnPunishCreditchina", rptTnPunishCreditchina);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("api:rpttnpunishcreditchina:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody RptTnPunishCreditchinaEntity rptTnPunishCreditchina){
			rptTnPunishCreditchinaService.insert(rptTnPunishCreditchina);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("api:rpttnpunishcreditchina:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody RptTnPunishCreditchinaEntity rptTnPunishCreditchina){
			rptTnPunishCreditchinaService.updateById(rptTnPunishCreditchina);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("api:rpttnpunishcreditchina:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			rptTnPunishCreditchinaService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
