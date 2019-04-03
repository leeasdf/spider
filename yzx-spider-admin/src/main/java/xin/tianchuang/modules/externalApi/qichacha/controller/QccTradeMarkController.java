package xin.tianchuang.modules.externalApi.qichacha.controller;

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
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTradeMarkEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTradeMarkService;


/**
 * 企查查-商标查询表
 *
 * @author hui.deng
 * @email
 * @date 2018-12-21 17:13:20
 */
@RestController
@RequestMapping("externalApi/qcctrademark")
@Api(value = "", description = "")
public class QccTradeMarkController {
    @Autowired
    private QccTradeMarkService qccTradeMarkService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("externalApi:qcctrademark:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qccTradeMarkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("externalApi:qcctrademark:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
        QccTradeMarkEntity qccTradeMark = qccTradeMarkService.selectById(id);

        return R.ok().put("qccTradeMark", qccTradeMark);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("externalApi:qcctrademark:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody QccTradeMarkEntity qccTradeMark){
        qccTradeMarkService.insert(qccTradeMark);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("externalApi:qcctrademark:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody QccTradeMarkEntity qccTradeMark){
        qccTradeMarkService.updateById(qccTradeMark);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("externalApi:qcctrademark:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
        qccTradeMarkService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
