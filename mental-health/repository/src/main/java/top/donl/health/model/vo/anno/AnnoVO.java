package top.donl.health.model.vo.anno;

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
@ApiModel(value = "公告")
public class AnnoVO {

    @ApiModelProperty(value = "公告ID")
    private Long id;

    @ApiModelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
