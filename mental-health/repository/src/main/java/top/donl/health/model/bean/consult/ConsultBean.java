package top.donl.health.model.bean.consult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "咨询")
public class ConsultBean {

    @NotNull(message = "咨询ID不能为空", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "咨询ID")
    private Long id;

    @NotBlank(message = "咨询标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 100, message = "咨询标题最多100字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "咨询", required = true)
    private String title;


    @NotBlank(message = "咨询描述不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 500, message = "咨询描述最多500字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "咨询描述", required = true)
    private String desc;
}
