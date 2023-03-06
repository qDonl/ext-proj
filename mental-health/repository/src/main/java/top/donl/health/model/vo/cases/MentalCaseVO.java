package top.donl.health.model.vo.cases;

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
@ApiModel(value = "案例")
public class MentalCaseVO {

    @ApiModelProperty(value = "案例ID")
    private Long id;

    @ApiModelProperty(value = "案例标题")
    private String title;

    @ApiModelProperty(value = "案例内容")
    private String content;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
