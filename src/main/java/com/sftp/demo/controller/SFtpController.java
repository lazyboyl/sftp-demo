package com.sftp.demo.controller;

import com.sftp.demo.config.SFtpConfig;
import com.sftp.demo.util.SFtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author linzf
 * @since 2019/10/8
 * 类描述： 测试文件上传
 */
@RestController
@RequestMapping("sftp")
public class SFtpController {

    @Autowired
    private SFtpConfig sFtpConfig;

    /**
     * 功能描述： 实现文件上传
     * @param file
     * @return
     */
    @PostMapping("uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        SFtpUtil.uploadFile("",file.getOriginalFilename(),file.getInputStream(),sFtpConfig);
        return "success";
    }

}
