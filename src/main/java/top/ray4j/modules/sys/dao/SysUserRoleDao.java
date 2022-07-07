package top.ray4j.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.modules.sys.entity.SysUserRole;

/**
 * 用户与角色对应关系
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}
