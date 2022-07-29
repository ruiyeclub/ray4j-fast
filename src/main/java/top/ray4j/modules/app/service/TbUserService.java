package top.ray4j.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ray4j.modules.app.dto.LoginDTO;
import top.ray4j.modules.app.entity.TbUser;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface TbUserService extends IService<TbUser> {

    TbUser queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回用户ID
     */
    long login(LoginDTO form);
}
