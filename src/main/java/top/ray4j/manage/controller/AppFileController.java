package top.ray4j.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.ray4j.common.constant.R;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 *
 * @author raychen
 */
@Api(tags = "【文件上传】API", description = "通用文件模块")
@RestController
@RequestMapping("file")
public class AppFileController {


    @Value("${file_root_path.url}")
    private String path;


    @PostMapping(value = "/fileUpload")
    @ApiOperation("上传图片")
    public R fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return R.error("请选择文件");
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径 // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(path + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回图片名称
        return R.ok().put("data", fileName);
    }
}