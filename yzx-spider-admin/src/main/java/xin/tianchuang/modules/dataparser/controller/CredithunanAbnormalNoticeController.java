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
import xin.tianchuang.modules.dataparser.entity.CredithunanAbnormalNoticeEntity;
import xin.tianchuang.modules.dataparser.rabbitmq.SendMsgHandler;
import xin.tianchuang.modules.dataparser.service.CredithunanAbnormalNoticeService;
import xin.tianchuang.modules.spider.enums.SpiderTypeEnum;


/**
 * 信用湖南-非正常户公告信息
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-12 17:55:57
 */
@RestController
@RequestMapping("dataparser/credithunanabnormalnotice")
@Api(value = "", description = "")
public class CredithunanAbnormalNoticeController {
    @Autowired
    private CredithunanAbnormalNoticeService credithunanAbnormalNoticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = credithunanAbnormalNoticeService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     *
     */
    @RequestMapping("/info/taxpayer")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:info")
    @ApiOperation(value = "", notes="")
    public R infoByTaxpayer(@RequestParam String taxpayer){
        CredithunanAbnormalNoticeEntity credithunanAbnormalNotice = credithunanAbnormalNoticeService.selectByTaxpayer(taxpayer);

        return R.ok().put("credithunanAbnormalNotice", credithunanAbnormalNotice);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			CredithunanAbnormalNoticeEntity credithunanAbnormalNotice = credithunanAbnormalNoticeService.selectById(id);

        return R.ok().put("credithunanAbnormalNotice", credithunanAbnormalNotice);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody CredithunanAbnormalNoticeEntity credithunanAbnormalNotice){
			credithunanAbnormalNoticeService.insert(credithunanAbnormalNotice);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody CredithunanAbnormalNoticeEntity credithunanAbnormalNotice){
			credithunanAbnormalNoticeService.updateById(credithunanAbnormalNotice);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			credithunanAbnormalNoticeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    @Autowired
    private SendMsgHandler sendMsgHandler;
    /**
     * 人工重试
     */
    @SysLog("人工重试xx")
    @RequestMapping("/reset")
    @RequiresPermissions("dataparser:credithunanabnormalnotice:reset")
    @ApiOperation(value = "", notes="")
    public R reset(@RequestBody String entName){
        sendMsgHandler.sendSpiderDataMsgToSpider(entName, SpiderTypeEnum.ABNORMAL_NOTICE);
        return R.ok();
    }

}
