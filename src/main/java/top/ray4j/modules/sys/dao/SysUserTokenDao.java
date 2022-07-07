package top.ray4j.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.modules.sys.entity.SysUserToken;

/**
 * 系统用户Token
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserToken> {

}
