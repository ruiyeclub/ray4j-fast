package top.ray4j.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysCaptchaDao;
import top.ray4j.modules.sys.entity.SysCaptcha;
import top.ray4j.modules.sys.service.SysCaptchaService;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptcha> implements SysCaptchaService {

}
