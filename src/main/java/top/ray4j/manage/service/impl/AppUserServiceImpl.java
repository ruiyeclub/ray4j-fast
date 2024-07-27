package top.ray4j.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import top.ray4j.common.exception.RRException;
import top.ray4j.common.validator.Assert;
import top.ray4j.manage.dao.AppUserDao;
import top.ray4j.manage.entity.AppUser;
import top.ray4j.manage.form.LoginForm;
import top.ray4j.manage.service.AppUserService;

/**
 * (AppUser)表服务实现类
 *
 * @author Cr.
 * @since 2024-06-24 15:04:04
 */
@Service("appUserService")
public class AppUserServiceImpl extends ServiceImpl<AppUserDao, AppUser> implements AppUserService {


    @Override
    public AppUser queryByName(String name) {
        return baseMapper.selectOne(new QueryWrapper<AppUser>().eq("username", name));
    }

    @Override
    public long login(LoginForm form) {
        AppUser user = queryByName(form.getUsername());
        Assert.isNull(user, "用户名或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new RRException("用户名或密码错误");
        }

        return user.getId();
    }

}

