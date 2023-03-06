package top.donl.health.model.vo.consultReply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "咨询")
public class ConsultReplyVO {

    @ApiModelProperty(value = "咨询回复ID")
    private Long id;

    @ApiModelProperty(value = "咨询ID")
    private Long consultId;

    @ApiModelProperty(value = "咨询回复", required = true)
    private String replyContent;

    @ApiModelProperty(value = "回复人")
    private String replier;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
