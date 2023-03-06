package top.donl.health.model.query.consultReply;

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
@ApiModel(value = "咨询回复查询")
public class ConsultReplyQuery extends BaseQuery {

    @ApiModelProperty(value = "咨询ID")
    private Long consultId;
}
