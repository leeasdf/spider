
package xin.tianchuang.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 登录表单
 *
 * @author xx
 * @since 3.1.0 2018-01-25
 */
@ApiModel(value = "登录表单")
public class LoginForm {
	
	@ApiModelProperty(value = "用户名称")
    @NotBlank(message="用户名称不能为空")
    private String userName;
	
    @ApiModelProperty(value = "手机号")
//    @NotBlank(message="手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}