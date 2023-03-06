package top.donl.health.model.bean.msg;

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
@ApiModel(value = "留言板")
public class MsgBoardBean {

    @NotNull(message = "公告ID不能为空", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "留言板ID")
    private Long id;

    @ApiModelProperty(value = "留言详情", required = true)
    @Max(value = 500, message = "留言内容最多500字", groups = {InsertGroup.class, UpdateGroup.class})
    @NotBlank(message = "留言内容不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    private String content;
}
