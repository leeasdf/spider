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

import xin.tianchuang.modules.dataparser.entity.CredithunanAdministrativePenaltyEntity;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CredithunanAdministrativePenaltyService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 双公示-行政处罚列表
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
@RestController
@RequestMapping("dataparser/credithunanadministrativepenalty")
@Api(value = "", description = "")
public class CredithunanAdministrativePenaltyController {
    @Autowired
    private CredithunanAdministrativePenaltyService credithunanAdministrativePenaltyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanAdministrativePenaltyService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/info/list")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:list")
    @ApiOperation(value = "", notes="")
    public R listCaseObject(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanAdministrativePenaltyService.queryPageCaseObject(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CredithunanAdministrativePenaltyEntity credithunanAdministrativePenalty = credithunanAdministrativePenaltyService.selectById(id);

        return R.ok().put("credithunanAdministrativePenalty", credithunanAdministrativePenalty);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/caseObject")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:info")
    @ApiOperation(value = "", notes="")
    public R infoByCaseObject(@RequestParam String caseObject){
        CredithunanAdministrativePenaltyEntity credithunanAdministrativePenalty =
                credithunanAdministrativePenaltyService.selectByCaseObject(caseObject);

        return R.ok().put("credithunanAdministrativePenalty", credithunanAdministrativePenalty);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CredithunanAdministrativePenaltyEntity credithunanAdministrativePenalty){
			credithunanAdministrativePenaltyService.insert(credithunanAdministrativePenalty);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CredithunanAdministrativePenaltyEntity credithunanAdministrativePenalty){
			credithunanAdministrativePenaltyService.updateById(credithunanAdministrativePenalty);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			credithunanAdministrativePenaltyService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @Autowired
    private SendMsgHandler sendMsgHandler;
    /**
     * 人工重试
     */
    @SysLog("人工重试xx")
    @RequestMapping("/reset")
    @RequiresPermissions("dataparser:credithunanadministrativepenalty:reset")
    @ApiOperation(value = "", notes="")
    public R reset(@RequestBody String entName){
        sendMsgHandler.sendSpiderDataMsgToSpider(entName, SpiderTypeEnum.ADMINISTRATIVE_PUNISHMENT);
        return R.ok();
    }
}
