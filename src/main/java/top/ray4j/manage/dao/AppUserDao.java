package top.ray4j.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.manage.entity.AppUser;

/**
 * (AppUser)表数据库访问层
 *
 * @author Cr.
 * @since 2024-06-24 15:04:04
 */
@Mapper
public interface AppUserDao extends BaseMapper<AppUser> {
}

