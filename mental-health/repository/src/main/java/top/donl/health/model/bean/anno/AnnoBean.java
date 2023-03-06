package top.donl.health.model.bean.anno;

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
@ApiModel(value = "公告")
public class AnnoBean {

    @NotNull(message = "公告ID不能为空", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "公告ID")
    private Long id;

    @NotBlank(message = "公告内容不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 500, message = "公告最多500字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "公告内容", required = true)
    private String content;
}
