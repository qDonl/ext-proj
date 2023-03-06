package top.donl.health.model.bean.cases;

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
@ApiModel(value = "案例")
public class MentalCaseBean {

    @NotNull(message = "案例ID不能为空", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "案例ID")
    private Long id;

    @NotBlank(message = "案例标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 50, message = "案例标题最多50字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "案例标题", required = true)
    private String title;


    @NotBlank(message = "案例内容不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 1000, message = "案例最多1000字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "案例内容", required = true)
    private String content;
}
