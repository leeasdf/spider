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
import xin.tianchuang.modules.externalApi.qichacha.entity.QccSeriousViolationEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccSeriousViolationService;


/**
 * 企查查-严重违法信息表
 *
 * @author hui.deng
 * @email 
 * @date 2019-01-02 14:34:47
 */
@RestController
@RequestMapping("qichacha/qccseriousviolation")
@Api(value = "", description = "")
public class QccSeriousViolationController {
    @Autowired
    private QccSeriousViolationService qccSeriousViolationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("qichacha:qccseriousviolation:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qccSeriousViolationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("qichacha:qccseriousviolation:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			QccSeriousViolationEntity qccSeriousViolation = qccSeriousViolationService.selectById(id);

        return R.ok().put("qccSeriousViolation", qccSeriousViolation);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("qichacha:qccseriousviolation:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody QccSeriousViolationEntity qccSeriousViolation){
			qccSeriousViolationService.insert(qccSeriousViolation);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("qichacha:qccseriousviolation:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody QccSeriousViolationEntity qccSeriousViolation){
			qccSeriousViolationService.updateById(qccSeriousViolation);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("qichacha:qccseriousviolation:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			qccSeriousViolationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
