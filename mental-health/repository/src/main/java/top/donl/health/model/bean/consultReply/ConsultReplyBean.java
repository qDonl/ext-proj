package top.donl.health.model.bean.consultReply;

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

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/03/06 10:46:27
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "咨询回复")
public class ConsultReplyBean {

    @NotNull(message = "咨询回复ID不能为空", groups = {UpdateGroup.class})
    @ApiModelProperty(value = "咨询回复ID")
    private Long id;

    @NotNull(message = "咨询ID不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "咨询ID")
    private Long consultId;

    @NotBlank(message = "咨询回复不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 1000, message = "咨询回复最多1000字符", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "咨询回复", required = true)
    private String replyContent;
}
