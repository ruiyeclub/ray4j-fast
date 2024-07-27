package top.ray4j.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.manage.dao.AppLogDao;
import top.ray4j.manage.entity.AppLog;
import top.ray4j.manage.service.AppLogService;

@Service("appLogService")
public class AppLogServiceImpl extends ServiceImpl<AppLogDao, AppLog> implements AppLogService {

}
