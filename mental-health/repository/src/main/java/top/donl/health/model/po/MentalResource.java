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
    * 心理资源推荐
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mental_resource")
public class MentalResource extends BaseEntity<MentalResource> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资源名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 资源描述
     */
    @TableField(value = "`desc`")
    private String desc;

    /**
     * 资源缩略图
     */
    @TableField(value = "thumbnail")
    private String thumbnail;

    /**
     * 附件ID
     */
    @TableField(value = "attachment")
    private String attachment;

    /**
     * 发布者
     */
    @TableField(value = "publisher")
    private String publisher;
}