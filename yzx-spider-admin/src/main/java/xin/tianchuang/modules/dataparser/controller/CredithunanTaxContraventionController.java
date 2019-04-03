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

import xin.tianchuang.modules.dataparser.entity.CredithunanTaxContraventionEntity;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CredithunanTaxContraventionService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 重大税收违法案件公告信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
@RestController
@RequestMapping("dataparser/credithunantaxcontravention")
@Api(value = "", description = "")
public class CredithunanTaxContraventionController {
    @Autowired
    private CredithunanTaxContraventionService credithunanTaxContraventionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:credithunantaxcontravention:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanTaxContraventionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:credithunantaxcontravention:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CredithunanTaxContraventionEntity credithunanTaxContravention = credithunanTaxContraventionService.selectById(id);

        return R.ok().put("credithunanTaxContravention", credithunanTaxContravention);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/taxpayer")
    @RequiresPermissions("dataparser:credithunantaxcontravention:info")
    @ApiOperation(value = "", notes="")
    public R info(@RequestParam String  taxpayer,String source){
        CredithunanTaxContraventionEntity credithunanTaxContravention = credithunanTaxContraventionService.selectByTaxpayer(taxpayer,source);

        return R.ok().put("credithunanTaxContravention", credithunanTaxContravention);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:credithunantaxcontravention:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CredithunanTaxContraventionEntity credithunanTaxContravention){
			credithunanTaxContraventionService.insert(credithunanTaxContravention);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:credithunantaxcontravention:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CredithunanTaxContraventionEntity credithunanTaxContravention){
			credithunanTaxContraventionService.updateById(credithunanTaxContravention);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:credithunantaxcontravention:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			credithunanTaxContraventionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    @Autowired
    private SendMsgHandler sendMsgHandler;
    /**
     * 人工重试
     */
    @SysLog("人工重试xx")
    @RequestMapping("/reset")
    @RequiresPermissions("dataparser:credithunantaxa:reset")
    @ApiOperation(value = "", notes="")
    public R reset(@RequestBody String entName){
        sendMsgHandler.sendSpiderDataMsgToSpider(entName, SpiderTypeEnum.MAJOR_TAX_OFFENCES);
        return R.ok();
    }

}
