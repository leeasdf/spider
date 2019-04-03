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

import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CreditchinaBaseInfoService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 信用中国-基本信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-15 15:36:13
 */
@RestController
@RequestMapping("dataparser/creditchinabaseinfo")
@Api(value = "", description = "")
public class CreditchinaBaseInfoController {
    @Autowired
    private CreditchinaBaseInfoService creditchinaBaseInfoService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:creditchinabaseinfo:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = creditchinaBaseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:creditchinabaseinfo:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CreditchinaBaseInfoEntity creditchinaBaseInfo = creditchinaBaseInfoService.selectById(id);

        return R.ok().put("creditchinaBaseInfo", creditchinaBaseInfo);
    }

    @RequestMapping("/info/entName")
    @RequiresPermissions("dataparser:creditchinabaseinfo:info")
    @ApiOperation(value = "", notes="")
    public R info(@RequestParam String entName){
        CreditchinaBaseInfoEntity creditchinaBaseInfo = creditchinaBaseInfoService.getByNameOrCreditCode(entName,null);
        return R.ok().put("creditchinaBaseInfo", creditchinaBaseInfo);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:creditchinabaseinfo:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CreditchinaBaseInfoEntity creditchinaBaseInfo){
			creditchinaBaseInfoService.insert(creditchinaBaseInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:creditchinabaseinfo:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CreditchinaBaseInfoEntity creditchinaBaseInfo){
			creditchinaBaseInfoService.updateById(creditchinaBaseInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:creditchinabaseinfo:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			creditchinaBaseInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @Autowired
    private SendMsgHandler sendMsgHandler;
    /**
     * 人工重试
     */
    @SysLog("人工重试xx")
    @RequestMapping("/reset")
    @RequiresPermissions("dataparser:creditchinabaseinfo:reset")
    @ApiOperation(value = "", notes="")
    public R reset(@RequestBody String entName){
        sendMsgHandler.sendSpiderDataMsgToSpider(entName,SpiderTypeEnum.CREDIT_CHINA);
        return R.ok();
    }

}
