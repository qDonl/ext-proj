package top.donl.health.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import top.donl.mybatisplus.model.BaseEntity;

/**
    * 系统公告
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_anno")
public class SysAnno extends BaseEntity<SysAnno> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公告内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 发布者
     */
    @TableField(value = "publisher")
    private String publisher;
}