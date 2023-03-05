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
    * 咨询
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "consult")
public class Consult extends BaseEntity<Consult> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 咨询标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 问题描述描述
     */
    @TableField(value = "`desc`")
    private String desc;

    /**
     * 咨询者姓名
     */
    @TableField(value = "consultant")
    private String consultant;
}