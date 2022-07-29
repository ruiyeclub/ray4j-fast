package top.ray4j.modules.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import top.ray4j.common.exception.RRException;
import top.ray4j.common.validator.Assert;
import top.ray4j.modules.app.dao.TbUserDao;
import top.ray4j.modules.app.dto.LoginDTO;
import top.ray4j.modules.app.entity.TbUser;
import top.ray4j.modules.app.service.TbUserService;


@Service("tbUserService")
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {

    @Override
    public TbUser queryByMobile(String mobile) {
        return baseMapper.selectOne(new LambdaQueryWrapper<TbUser>().eq(TbUser::getMobile, mobile));
    }

    @Override
    public long login(LoginDTO form) {
        TbUser user = queryByMobile(form.getMobile());
        Assert.isNull(user, "手机号或密码错误");

        // 密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
            throw new RRException("手机号或密码错误");
        }
        return user.getUserId();
    }
}
