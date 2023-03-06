package top.donl.health.model.vo.consult;

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
public class ConsultVO {

    @ApiModelProperty(value = "咨询ID")
    private Long id;

    @ApiModelProperty(value = "咨询", required = true)
    private String title;

    @ApiModelProperty(value = "咨询描述", required = true)
    private String desc;

    @ApiModelProperty(value = "咨询人")
    private String consultant;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
