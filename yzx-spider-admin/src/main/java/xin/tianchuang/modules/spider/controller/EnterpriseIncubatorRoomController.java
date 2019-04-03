package xin.tianchuang.modules.spider.controller;

import java.util.Arrays;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.tianchuang.common.annotation.SysLog;

import xin.tianchuang.modules.spider.entity.EnterpriseIncubatorRoomEntity;
import xin.tianchuang.modules.spider.service.EnterpriseIncubatorRoomService;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;



/**
 * 
 *
 * @author hui.deng
 * @email 
 * @date 2018-09-26 11:44:36
 */
@RestController
@RequestMapping("spider/enterpriseincubatorroom")
@Api("")
public class EnterpriseIncubatorRoomController {
    @Autowired
    private EnterpriseIncubatorRoomService enterpriseIncubatorRoomService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("spider:enterpriseincubatorroom:list")
    @ApiOperation("")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterpriseIncubatorRoomService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("spider:enterpriseincubatorroom:info")
    @ApiOperation("")
    public R info(@PathVariable("id") Long id){
			EnterpriseIncubatorRoomEntity enterpriseIncubatorRoom = enterpriseIncubatorRoomService.selectById(id);

        return R.ok().put("enterpriseIncubatorRoom", enterpriseIncubatorRoom);
    }

    /**
     * 保存
     */
    @SysLog("保存")
    @PostMapping("/save")
    @RequiresPermissions("spider:enterpriseincubatorroom:save")
    @ApiOperation("")
    public R save(@RequestBody EnterpriseIncubatorRoomEntity enterpriseIncubatorRoom){
			enterpriseIncubatorRoomService.insert(enterpriseIncubatorRoom);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改")
    @PostMapping("/update")
    @RequiresPermissions("spider:enterpriseincubatorroom:update")
    @ApiOperation("")
    public R update(@RequestBody EnterpriseIncubatorRoomEntity enterpriseIncubatorRoom){
			enterpriseIncubatorRoomService.updateById(enterpriseIncubatorRoom);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除")
    @PostMapping("/delete")
    @RequiresPermissions("spider:enterpriseincubatorroom:delete")
    @ApiOperation("")
    public R delete(@RequestBody Long[] ids) {
			enterpriseIncubatorRoomService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
