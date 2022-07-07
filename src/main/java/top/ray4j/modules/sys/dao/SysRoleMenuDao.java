package top.ray4j.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.modules.sys.entity.SysRoleMenu;

/**
 * 角色与菜单对应关系
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

}
