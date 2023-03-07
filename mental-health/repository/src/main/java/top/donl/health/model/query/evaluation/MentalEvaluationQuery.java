package top.donl.health.model.query.evaluation;

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
@ApiModel(value = "咨询评估推荐地址")
public class MentalEvaluationQuery extends BaseQuery {

    @ApiModelProperty(value = "关键词")
    private String keyword;
}
