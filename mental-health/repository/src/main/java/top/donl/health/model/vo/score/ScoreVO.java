package top.donl.health.model.vo.score;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class ScoreVO {

    private Long id;

    private Long evaluationId;

    private String evaluationTitle;

    private BigDecimal score;

    private String realName;

    private LocalDateTime createTime;
}
