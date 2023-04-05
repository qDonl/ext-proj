package top.donl.health.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.mybatisplus.model.BaseEntity;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "evaluation_score")
public class EvaluationScore extends BaseEntity<EvaluationScore> {
    /**
     * 评估得分
     */
    @TableField(value = "score")
    private BigDecimal score;

    /**
     * 评估ID
     */
    @TableField(value = "evaluation_id")
    private Long evaluationId;

    /**
     * 评估名称
     */
    @TableField(value = "evaluation_title")
    private String evaluationTitle;
}