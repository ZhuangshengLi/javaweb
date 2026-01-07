package com.iheima.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iheima.pojo.ClazzCountOption;
import com.iheima.pojo.JobOption;
import com.iheima.pojo.Result;
import com.iheima.service.ReportService;

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

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("Get student degree data");
        List<Map> dataList = reportService.getStudentDegreeData();
        return Result.success(dataList);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("Get student count data");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();
        return Result.success(clazzCountOption);
    }
}
