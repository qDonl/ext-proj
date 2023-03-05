package top.donl.health.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 09:39:49
 */


@Data
@TableName("account")
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer balance;
    private Integer status;
}
