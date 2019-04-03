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

import xin.tianchuang.modules.dataparser.entity.CredithunanTaxAEntity;
import xin.tianchuang.modules.dataparser.enums.CredithunanTaxATypeEnum;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CredithunanTaxAService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 年度纳税信用A级纳税人名单
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-28 14:45:04
 */
@RestController
@RequestMapping("dataparser/credithunantaxa")
@Api(value = "", description = "")
public class CredithunanTaxAController {
    @Autowired
    private CredithunanTaxAService credithunanTaxAService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:credithunantaxa:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanTaxAService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/taxpayer")
    @RequiresPermissions("dataparser:credithunantaxa:info")
    @ApiOperation(value = "", notes="")
    public R info(@RequestParam String  taxpayer,String source){
			CredithunanTaxAEntity credithunanTaxA = credithunanTaxAService.selectByTaxpayer(taxpayer,source);

        return R.ok().put("credithunanTaxA", credithunanTaxA);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:credithunantaxa:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
        CredithunanTaxAEntity credithunanTaxA = credithunanTaxAService.selectById(id);

        return R.ok().put("credithunanTaxA", credithunanTaxA);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:credithunantaxa:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CredithunanTaxAEntity credithunanTaxA){
			credithunanTaxAService.insert(credithunanTaxA);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:credithunantaxa:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CredithunanTaxAEntity credithunanTaxA){
			credithunanTaxAService.updateById(credithunanTaxA);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:credithunantaxa:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			credithunanTaxAService.deleteBatchIds(Arrays.asList(ids));

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
    public R reset(@RequestParam String entName ,String taxtype){
        CredithunanTaxATypeEnum type=CredithunanTaxATypeEnum.valueOf(taxtype);
        SpiderTypeEnum typeEnum=null;
        if(CredithunanTaxATypeEnum.NATIONAL_TAX==type){
            typeEnum=SpiderTypeEnum.LEVEL_A_TAXER;
        }else  if(CredithunanTaxATypeEnum.LAND_TAX==type){
            typeEnum=SpiderTypeEnum.CREDIT_A_TAXPAYER;
        }
        sendMsgHandler.sendSpiderDataMsgToSpider(entName, typeEnum);
        return R.ok();
    }

}
