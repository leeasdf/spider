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

import xin.tianchuang.modules.externalApi.qichacha.entity.QccCopyrightEntity;
import xin.tianchuang.modules.externalApi.qichacha.service.QccCopyrightService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 企查查API-软件著作权
 *
 * @author hui.deng
 * @email 
 * @date 2018-12-19 17:47:48
 */
@RestController
@RequestMapping("qichacha/qcccopyright")
@Api(value = "", description = "")
public class QccCopyrightController {
    @Autowired
    private QccCopyrightService qccCopyrightService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("qichacha:qcccopyright:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qccCopyrightService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("qichacha:qcccopyright:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Long id){
			QccCopyrightEntity qccCopyright = qccCopyrightService.selectById(id);

        return R.ok().put("qccCopyright", qccCopyright);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("qichacha:qcccopyright:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody QccCopyrightEntity qccCopyright){
			qccCopyrightService.insert(qccCopyright);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("qichacha:qcccopyright:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody QccCopyrightEntity qccCopyright){
			qccCopyrightService.updateById(qccCopyright);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("qichacha:qcccopyright:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Long[] ids){
			qccCopyrightService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
