package top.ray4j.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ray4j.common.exception.RRException;
import top.ray4j.common.utils.DateUtils;
import top.ray4j.manage.dao.AppCaptchaDao;
import top.ray4j.manage.entity.AppCaptcha;
import top.ray4j.manage.service.AppCaptchaService;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("appCaptchaService")
public class AppCaptchaServiceImpl extends ServiceImpl<AppCaptchaDao, AppCaptcha> implements AppCaptchaService {

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        AppCaptcha captchaEntity = new AppCaptcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        AppCaptcha captchaEntity = this.getOne(new QueryWrapper<AppCaptcha>().eq("uuid", uuid));
        if (captchaEntity == null) {
            return false;
        }

        //删除验证码
        this.removeById(uuid);

        return captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis();
    }

}
