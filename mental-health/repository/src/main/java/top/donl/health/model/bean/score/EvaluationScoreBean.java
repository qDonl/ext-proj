package top.donl.health.model.bean.score;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class EvaluationScoreBean {

    @NotNull(message = "请选择评估")
    private Long evaluationId;

    @NotBlank(message = "请选择评估")
    private String evaluationTitle;

    @NotNull(message = "请输入得分")
    private BigDecimal score;
}
