package com.iheima.web_tlisas_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;
import com.iheima.web_tlisas_management.pojo.PageResult;
import com.iheima.web_tlisas_management.pojo.Result;
import com.iheima.web_tlisas_management.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
        public Result page(EmpQueryParam empQueryParam) {
        log.info("Page Query all employees {}", empQueryParam);
        PageResult<Emp> emps = empService.page(empQueryParam);
        return Result.success(emps);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) throws Exception {
        log.info("Save employee: {}", emp);
        empService.save(emp);
        return Result.success();
    }

}
