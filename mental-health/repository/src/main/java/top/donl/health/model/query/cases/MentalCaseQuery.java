package top.donl.health.model.query.cases;

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
@ApiModel(value = "案例搜索")
public class MentalCaseQuery extends BaseQuery {

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;
}
