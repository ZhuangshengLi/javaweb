package com.iheima.web_tlisas_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iheima.web_tlisas_management.pojo.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public Result upload(MultipartFile file) {
        log.info("Upload file: {}", file.getOriginalFilename());
        return Result.success();
    }
}
