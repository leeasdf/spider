package xin.tianchuang.modules.dataparser.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.annotation.SysLog;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativeLicensingEntity;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CredithunanAdministrativeLicensingService;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 双公示-行政许可列表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-12 17:55:57
 */
@RestController
@RequestMapping("dataparser/credithunanadministrativelicensing")
@Api(value = "", description = "")
public class CredithunanAdministrativeLicensingController {
    @Autowired
    private CredithunanAdministrativeLicensingService credithunanAdministrativeLicensingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanAdministrativeLicensingService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:list")
    @ApiOperation(value = "", notes="")
    public R listByCaseObject(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanAdministrativeLicensingService.queryPageByCaseObject(params);
        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/caseObject")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:info")
    @ApiOperation(value = "", notes="")
    public R infoByCaseObject(@RequestParam String caseObject){
        CredithunanAdministrativeLicensingEntity credithunanAdministrativeLicensing = credithunanAdministrativeLicensingService.selectByCaseObject(caseObject);

        return R.ok().put("credithunanAdministrativeLicensing", credithunanAdministrativeLicensing);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CredithunanAdministrativeLicensingEntity credithunanAdministrativeLicensing = credithunanAdministrativeLicensingService.selectById(id);

        return R.ok().put("credithunanAdministrativeLicensing", credithunanAdministrativeLicensing);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CredithunanAdministrativeLicensingEntity credithunanAdministrativeLicensing){
			credithunanAdministrativeLicensingService.insert(credithunanAdministrativeLicensing);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CredithunanAdministrativeLicensingEntity credithunanAdministrativeLicensing){
			credithunanAdministrativeLicensingService.updateById(credithunanAdministrativeLicensing);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			credithunanAdministrativeLicensingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @Autowired
    private SendMsgHandler sendMsgHandler;
    /**
     * 人工重试
     */
    @SysLog("人工重试xx")
    @RequestMapping("/reset")
    @RequiresPermissions("dataparser:credithunanadministrativelicensing:reset")
    @ApiOperation(value = "", notes="")
    public R reset(@RequestBody String entName){
        sendMsgHandler.sendSpiderDataMsgToSpider(entName, SpiderTypeEnum.ADMINISTRATIVE_LICENSING);
        return R.ok();
    }

}
