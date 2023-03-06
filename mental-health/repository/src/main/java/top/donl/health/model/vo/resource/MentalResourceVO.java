package top.donl.health.model.vo.resource;

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
@ApiModel(value = "资源推荐")
public class MentalResourceVO {

    @ApiModelProperty(value = "资源推荐ID")
    private Long id;

    @ApiModelProperty(value = "资源标题")
    private String title;

    @ApiModelProperty(value = "资源缩略图")
    private String thumbnail;

    @ApiModelProperty(value = "上传后的资源ID")
    private String attachment;

    @ApiModelProperty(value = "创建时间")
    public LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    public LocalDateTime updateTime;
}
