package top.donl.health.model.bean.evaluation;

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
@ApiModel(value = "心理测评推荐")
public class MentalEvaluationBean {

    @ApiModelProperty(value = "id")
    @NotNull(message = "请选择地址", groups = {UpdateGroup.class})
    private Long id;

    @Max(value = 50, message = "标题最长50字符")
    @NotBlank(message = "标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    @Max(value = 500, message = "地址最长500字符")
    @NotBlank(message = "地址不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "推荐地址", required = true)
    private String url;
}
