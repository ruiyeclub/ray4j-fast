package top.ray4j.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ray4j.manage.entity.AppCaptcha;

/**
 * 验证码
 *
 * @author: Cr.
 * @date: 2022/6/18
 */
@Mapper
public interface AppCaptchaDao extends BaseMapper<AppCaptcha> {

}
