package top.ray4j.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (AppUser)表实体类
 *
 * @author Cr.
 * @since 2024-06-24 15:04:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("app_user")
public class AppUser extends Model<AppUser> {

    @TableId(type = IdType.AUTO)
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;

    private Date createTime;

    private Date updateTime;

    private String email;
}

