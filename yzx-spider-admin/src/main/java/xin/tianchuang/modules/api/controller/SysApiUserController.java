package xin.tianchuang.modules.api.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.tianchuang.common.annotation.SysLog;
import xin.tianchuang.common.constant.Constant;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.validator.Assert;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.common.validator.group.AddGroup;
import xin.tianchuang.common.validator.group.UpdateGroup;
import xin.tianchuang.modules.sys.controller.AbstractController;
import xin.tianchuang.modules.sys.entity.SysUserEntity;
import xin.tianchuang.modules.sys.form.PasswordForm;
import xin.tianchuang.modules.sys.service.SysUserRoleService;
import xin.tianchuang.modules.sys.service.SysUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * API用户管理
 * @author idea
 * @version 1.0
 * @since 2018年10月29日 上午11:26
 **/
@RestController
@RequestMapping("/api/sysapiuser")
public class SysApiUserController  extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * 所有用户列表
     */
    @GetMapping("/list")
    @RequiresPermissions("api:sysapiuser:list")
    public R list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        String username = (String) params.get("username");
        int pageNum = Integer.valueOf(params.get("page").toString());
        int size = Integer.valueOf(params.get("limit").toString());
        Page<SysUserEntity> page = new Page<>(pageNum,size);
        page = sysUserService.queryByRoleId(page,Long.valueOf(2),username);
        return R.ok().put("page", new PageUtils(page));
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @PostMapping("/password")
    public R password(@RequestBody PasswordForm form){
        Assert.isBlank(form.getNewPassword(), "新密码不为能空");

        //sha256加密
        String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
        //sha256加密
        String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();

        //更新密码
        boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
        if(!flag){
            return R.error("原密码不正确");
        }

        return R.ok();
    }

    /**
     * 用户信息
     */
    @GetMapping("/info/{userId}")
    @RequiresPermissions("api:sysapiuser:info")
    public R info(@PathVariable("userId") Long userId){
        SysUserEntity user = sysUserService.selectById(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return R.ok().put("user", user);
    }

    /**
     * 保存用户
     */
    @SysLog("保存用户")
    @PostMapping("/save")
    @RequiresPermissions("api:sysapiuser:save")
    public R save(@RequestBody SysUserEntity user){
        ValidatorUtils.validateEntity(user, AddGroup.class);
        ArrayList<Long> roleList = new ArrayList<>();
        roleList.add(Long.valueOf(Constant.API_ROLE));
        user.setRoleIdList(roleList);
        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return R.ok();
    }

    /**
     * 修改用户
     */
    @SysLog("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("api:sysapiuser:update")
    public R update(@RequestBody SysUserEntity user){
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        ArrayList<Long> roleList = new ArrayList<>();
        roleList.add(Long.valueOf(Constant.API_ROLE));
        user.setRoleIdList(roleList);
        user.setCreateUserId(getUserId());
        sysUserService.update(user);

        return R.ok();
    }

    /**
     * 删除用户
     */
    @SysLog("删除用户")
    @PostMapping("/delete")
    @RequiresPermissions("api:sysapiuser:delete")
    public R delete(@RequestBody Long[] userIds){
        if(ArrayUtils.contains(userIds, 1L)){
            return R.error("系统管理员不能删除");
        }

        if(ArrayUtils.contains(userIds, getUserId())){
            return R.error("当前用户不能删除");
        }

        sysUserService.deleteBatch(userIds);

        return R.ok();
    }

}