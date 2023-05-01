package top.donl.health.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.awt.print.PrinterAbortException;

/**
 * @author Crux
 * @since 2023-03-05 19:32:35
 */


@ApiModel(value = "用户信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    @ApiModelProperty(value = "用户ID")
    private Long id;
    private String phone;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "角色(0:学生;1:教师;2:管理员)")
    private Integer role;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
