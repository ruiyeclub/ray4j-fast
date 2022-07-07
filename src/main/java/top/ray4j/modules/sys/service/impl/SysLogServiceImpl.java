package top.ray4j.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysLogDao;
import top.ray4j.modules.sys.entity.SysLog;
import top.ray4j.modules.sys.service.SysLogService;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService {

}
