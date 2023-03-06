package top.donl.health.model.query.resource;

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
@ApiModel(value = "资源推荐搜索")
public class MentalResourceQuery extends BaseQuery {

    @ApiModelProperty(value = "资源标题")
    private String title;
}
