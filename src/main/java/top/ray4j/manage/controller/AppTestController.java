package top.ray4j.manage.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ray4j.common.annotation.Log;
import top.ray4j.common.constant.R;
import top.ray4j.manage.annotation.Login;
import top.ray4j.manage.entity.AppUser;

/**
 * APP测试接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@Api(tags = "【用户测试】API", description = "提供测试相关的 Rest API")
@RestController
@RequestMapping("/test")
public class AppTestController {

    @Login
    @GetMapping("userInfo")
    @ApiOperation("获取用户信息-测试日志记录")
    @Log
    public R userInfo(AppUser user) {
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") Integer userId) {
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken() {
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
