package top.ray4j.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ray4j.common.constant.R;
import top.ray4j.common.validator.ValidatorUtils;
import top.ray4j.manage.annotation.Login;
import top.ray4j.manage.entity.AppUser;
import top.ray4j.manage.form.LoginForm;
import top.ray4j.manage.form.RegisterForm;
import top.ray4j.manage.service.AppCaptchaService;
import top.ray4j.manage.service.AppUserService;
import top.ray4j.manage.utils.JwtUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static top.ray4j.manage.interceptor.AuthorizationInterceptor.USERNAME_KEY;
import static top.ray4j.manage.interceptor.AuthorizationInterceptor.USER_KEY;

/**
 * APP登录授权
 *
 * @author Mark sunlightcs@gmail.com
 */
@Api(tags = "【用户登录】API", description = "提供app用户相关的 Rest API")
@RestController
@RequestMapping("/user")
public class AppLoginController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppCaptchaService appCaptchaService;
    @Autowired
    private JwtUtils jwtUtils;


    /**
     * 验证码
     */
    @ApiOperation("验证码")
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = appCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form) {
        boolean captcha = appCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        long userId = appUserService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userId, form.getUsername());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form) {
        boolean captcha = appCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }
        //表单校验
        ValidatorUtils.validateEntity(form);

        AppUser user = appUserService.getOne(new QueryWrapper<AppUser>().eq("username", form.getUsername()));
        if (null != user) {
            return R.error("用户名已存在");
        }
        if (!Objects.equals(form.getPassword(), form.getPasswordAgain())) {
            return R.error("密码不一致");
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(form.getUsername());
        appUser.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        appUser.setCreateTime(new Date());
        appUserService.save(appUser);

        return R.ok();
    }


    @PostMapping("emailNotice")
    @ApiOperation("邮箱设置")
    @Login
    public R emailNotice(@RequestParam @Email String email,
                         HttpServletRequest request) {
        // fixme: 无法使用Long接收
        Integer userId = (Integer) request.getAttribute(USER_KEY);
        AppUser appUser = appUserService.getById(userId);
        appUser.setEmail(email);
        appUserService.updateById(appUser);

        return R.ok();
    }


    @GetMapping("userInfo")
    @ApiOperation("个人信息")
    @Login
    public R userInfo(HttpServletRequest request) {
        // 获取订单号
        Integer userId = (Integer) request.getAttribute(USER_KEY);
        String username = (String) request.getAttribute(USERNAME_KEY);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);
        return R.ok().put("data", map);
    }
}
