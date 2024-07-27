package top.ray4j.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ray4j.common.constant.R;
import top.ray4j.manage.entity.AppLog;
import top.ray4j.manage.form.PageData;
import top.ray4j.manage.service.AppLogService;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@Api(tags = "【系统日志】API", description = "通用系统日志")
@RestController
@RequestMapping("/log")
public class AppLogController {

    @Autowired
    private AppLogService appLogService;

    /**
     * 列表
     */
    @ApiOperation("日志列表")
    @GetMapping("/page")
    public R list(PageData pageData) {
        IPage<AppLog> iPage = new Page<>(pageData.getPage(), pageData.getPageSize());
        return R.ok().put("page", appLogService.page(iPage, new QueryWrapper<>()));
    }

}
