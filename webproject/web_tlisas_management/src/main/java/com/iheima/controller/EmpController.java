package com.iheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iheima.pojo.Emp;
import com.iheima.pojo.EmpQueryParam;
import com.iheima.pojo.PageResult;
import com.iheima.pojo.Result;
import com.iheima.service.EmpService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;


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

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("Delete employees: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("Get employee by id: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("Update employee: {}", emp);
        empService.update(emp);
        return Result.success();
    }

}
