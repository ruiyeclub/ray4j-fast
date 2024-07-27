package top.ray4j.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.manage.entity.AppLog;

/**
 * 系统日志
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface AppLogDao extends BaseMapper<AppLog> {

}
