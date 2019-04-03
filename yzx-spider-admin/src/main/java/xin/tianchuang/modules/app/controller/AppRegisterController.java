package xin.tianchuang.modules.app.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.modules.app.form.RegisterForm;
import xin.tianchuang.modules.app.service.UserService;

/**
 * 注册
 * @author hui.deng
 * 
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        userService.register(form);

        return R.ok();
    }
}
