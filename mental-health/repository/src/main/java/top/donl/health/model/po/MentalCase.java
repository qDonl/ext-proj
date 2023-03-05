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
    * 心理测试案例
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mental_case")
public class MentalCase extends BaseEntity<MentalCase> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 案例名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 案例详情描述
     */
    @TableField(value = "content")
    private String content;

    /**
     * 发布者
     */
    @TableField(value = "publisher")
    private String publisher;
}