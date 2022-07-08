package top.ray4j.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysUserDao;
import top.ray4j.modules.sys.entity.SysUser;
import top.ray4j.modules.sys.service.SysUserService;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}
