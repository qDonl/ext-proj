package top.donl.health.model.query.consult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.util.common.domain.query.BaseQuery;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "咨询搜索")
public class ConsultQuery extends BaseQuery {

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

    @ApiModelProperty(value = "用户ID", hidden = true)
    private Long userId;
}
