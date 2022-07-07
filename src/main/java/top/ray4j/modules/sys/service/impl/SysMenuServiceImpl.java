package top.ray4j.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysMenuDao;
import top.ray4j.modules.sys.entity.SysMenu;
import top.ray4j.modules.sys.service.SysMenuService;

@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}
