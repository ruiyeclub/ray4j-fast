package top.ray4j.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.ray4j.modules.sys.dao.SysConfigDao;
import top.ray4j.modules.sys.entity.SysConfig;
import top.ray4j.modules.sys.service.SysConfigService;

@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfig> implements SysConfigService {

}
