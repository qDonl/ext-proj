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
    * 用户
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User extends BaseEntity<User> {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 用户角色(0:学生;1:教师;3:管理员)
     */
    @TableField(value = "`role`")
    private Integer role;
}