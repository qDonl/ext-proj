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
    * 咨询回复
    */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "consult_reply")
public class ConsultReply extends BaseEntity<ConsultReply> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 问题咨询ID
     */
    @TableField(value = "consult_id")
    private Long consultId;

    /**
     * 回复内容
     */
    @TableField(value = "reply_content")
    private String replyContent;

    /**
     * 回复者
     */
    @TableField(value = "replier")
    private String replier;
}