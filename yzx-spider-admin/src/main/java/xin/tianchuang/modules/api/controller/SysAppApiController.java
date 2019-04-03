package xin.tianchuang.modules.api.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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

import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 应用接口对照表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 16:25:42
 */
@RestController
@RequestMapping("api/sysappapi")
@Api(value = "", description = "")
public class SysAppApiController {
    @Autowired
    private SysAppApiService sysAppApiService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("api:sysappapi:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAppApiService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("api:sysappapi:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("id") Integer id){
			SysAppApiEntity sysAppApi = sysAppApiService.selectById(id);

        return R.ok().put("sysAppApi", sysAppApi);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    //@RequiresPermissions("api:sysappapi:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody SysAppApiEntity sysAppApi){
         if (sysAppApi.getApiIdList()!=null&&sysAppApi.getApiIdList().size()>0){
             SysAppApiEntity deleteCnd = new SysAppApiEntity();
             deleteCnd.setApiId(sysAppApi.getApiId());
             sysAppApiService.delete(new EntityWrapper<>(deleteCnd));
             for (Long appId : sysAppApi.getApiIdList()) {
                 SysAppApiEntity sysAppApiEntity = new SysAppApiEntity();
                 sysAppApiEntity.setAppId(sysAppApi.getAppId());
                 sysAppApiEntity.setApiId(appId);
                 sysAppApiEntity.setStatus(DataStatusEnum.ACTIVE.key());
                 sysAppApiService.insert(sysAppApiEntity);
             }
         }else {
             sysAppApiService.insert(sysAppApi);
         }
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("api:sysappapi:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody SysAppApiEntity sysAppApi){
        sysAppApiService.updateById(sysAppApi);
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("api:sysappapi:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Integer[] ids){
			sysAppApiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
