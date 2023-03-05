package top.donl.health.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.donl.mybatisplus.model.BaseEntity;


/**
    * 留言板
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "msg_board")
public class MsgBoard extends BaseEntity<MsgBoard> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 留言内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 发布者
     */
    @TableField(value = "publisher")
    private String publisher;
}