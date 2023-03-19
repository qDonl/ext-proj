package top.donl.health.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.mybatisplus.model.BaseEntity;

/**
    * 心理测评地址
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mental_evaluation")
public class MentalEvaluation extends BaseEntity<MentalEvaluation> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 心理测评地址名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 心理测评地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 推荐者名字
     */
    @TableField(value = "publisher")
    private String publisher;

    @TableField(value = "`desc`")
    private String desc;
}