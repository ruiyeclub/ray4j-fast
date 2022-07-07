package top.ray4j.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysUserRoleDao;
import top.ray4j.modules.sys.entity.SysUserRole;
import top.ray4j.modules.sys.service.SysUserRoleService;

/**
 * 用户与角色对应关系
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

}
