package top.ray4j.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ray4j.manage.entity.AppUser;
import top.ray4j.manage.form.LoginForm;

import java.util.List;

/**
 * (AppUser)表服务接口
 *
 * @author Cr.
 * @since 2024-06-24 15:04:04
 */
public interface AppUserService extends IService<AppUser> {


    AppUser queryByName(String name);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回用户ID
     */
    long login(LoginForm form);
}

