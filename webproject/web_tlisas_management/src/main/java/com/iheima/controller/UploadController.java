package com.iheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iheima.pojo.Result;
import com.iheima.utils.AliyunOSSOperator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("Upload file: {}", file.getOriginalFilename());

        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("Upload file success: {}", url);

        return Result.success(url);
    }
}
