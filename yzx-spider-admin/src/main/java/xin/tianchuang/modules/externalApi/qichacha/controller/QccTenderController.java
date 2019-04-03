package xin.tianchuang.modules.externalApi.qichacha.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.externalApi.qichacha.entity.QccTenderEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccTenderService;

import java.util.Arrays;
import java.util.Map;



/**
 * 企查查——企业招投标信息
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:29:53
 */
@RestController
@RequestMapping("qichacha/qcctender")
@Api(value = "", description = "")
public class QccTenderController {
    @Autowired
    private QccTenderService qccTenderService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("qichacha:qcctender:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qccTenderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("qichacha:qcctender:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			QccTenderEntity qccTender = qccTenderService.selectById(id);

        return R.ok().put("qccTender", qccTender);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("qichacha:qcctender:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody QccTenderEntity qccTender){
			qccTenderService.insert(qccTender);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("qichacha:qcctender:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody QccTenderEntity qccTender){
			qccTenderService.updateById(qccTender);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("qichacha:qcctender:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			qccTenderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
