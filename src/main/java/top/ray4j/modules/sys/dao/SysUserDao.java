package top.ray4j.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.modules.sys.entity.SysUser;

/**
 * 系统用户
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}
