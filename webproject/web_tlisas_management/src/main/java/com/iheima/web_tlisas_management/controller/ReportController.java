package com.iheima.web_tlisas_management.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iheima.web_tlisas_management.pojo.JobOption;
import com.iheima.web_tlisas_management.pojo.Result;
import com.iheima.web_tlisas_management.service.ReportService;

@Slf4j
@RestController
@RequestMapping("/report")

public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData() {
        log.info("Get employee job data");
        JobOption empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        log.info("Get employee gender data");
        List<Map<String, Object>> empGenderData = reportService.getEmpGenderData();
        return Result.success(empGenderData);
    }
}
