package top.donl.health.model.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@ApiModel(value = "用户注册")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBean {

    @Pattern(regexp = "[1][3,4,5,7,8][0-9]{9}$", message = "手机号格式错误")
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    @NotNull(message = "请选择注册角色")
    @ApiModelProperty(value = "用户角色(0:学生;1:教师;3:管理员)", required = true)
    private Integer role;

    @Size(min = 1, max = 10, message = "真实姓名1-10字符")
    @NotBlank(message = "真实姓名不能为空")
    @ApiModelProperty(value = "真实姓名", required = true)
    private String realName;

    @Size(min = 4, max = 16, message = "密码长度为4-16字符")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @NotBlank(message = "确认密码不能为空")
    @Size(min = 4, max = 16, message = "密码长度为4-16字符")
    @ApiModelProperty(value = "确认密码不能为空", required = true)
    private String confirmPassword;
}
