package xin.tianchuang.modules.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

import xin.tianchuang.modules.api.entity.SysApiMenuEntity;
import xin.tianchuang.modules.api.entity.SysAppApiEntity;
import xin.tianchuang.modules.api.entity.SysUserApiTokenEntity;
import xin.tianchuang.modules.api.service.SysApiMenuService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.modules.api.service.SysAppApiService;
import xin.tianchuang.modules.api.service.SysUserApiTokenService;


/**
 * api菜单表
 *
 * @author hui.deng
 * @email 
 * @date 2018-10-17 16:25:41
 */
@RestController
@RequestMapping("api/sysapimenu")
@Api(value = "", description = "")
public class SysApiMenuController {
    @Autowired
    private SysApiMenuService sysApiMenuService;

    @Autowired
    private SysUserApiTokenService sysUserApiTokenService;
    @Autowired
    private SysAppApiService sysAppApiService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("api:sysapimenu:list")
    @ApiOperation(value = "", notes="")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysApiMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{apiId}")
    @RequiresPermissions("api:sysapimenu:info")
    @ApiOperation(value = "", notes="")
    public R info(@PathVariable("apiId") Integer apiId){
			SysApiMenuEntity sysApiMenu = sysApiMenuService.selectById(apiId);

        return R.ok().put("sysApiMenu", sysApiMenu);
    }

    /**
     * 保存
     */
    @SysLog("保存xx")
    @RequestMapping("/save")
    @RequiresPermissions("api:sysapimenu:save")
    @ApiOperation(value = "", notes="")
    public R save(@RequestBody SysApiMenuEntity sysApiMenu){
			sysApiMenuService.insert(sysApiMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改xx")
    @RequestMapping("/update")
    @RequiresPermissions("api:sysapimenu:update")
    @ApiOperation(value = "", notes="")
    public R update(@RequestBody SysApiMenuEntity sysApiMenu){
			sysApiMenuService.updateById(sysApiMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除xx")
    @RequestMapping("/delete")
    @RequiresPermissions("api:sysapimenu:delete")
    @ApiOperation(value = "", notes="")
    public R delete(@RequestBody Integer[] apiIds){
			sysApiMenuService.deleteBatchIds(Arrays.asList(apiIds));

        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/listByAppId/{appId}")
    @RequiresPermissions("api:sysapimenu:list")
    @ApiOperation(value = "", notes="")
    public R listByUserId(@PathVariable("appId") Long appId){
        List<SysApiMenuEntity> list = new ArrayList<>();
        list = sysApiMenuService.queryApiMenuByAppId(appId);
        return R.ok().put("list", list);
    }

}
