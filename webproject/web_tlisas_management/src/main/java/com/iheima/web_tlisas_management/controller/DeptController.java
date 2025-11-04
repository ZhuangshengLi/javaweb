package com.iheima.web_tlisas_management.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.iheima.web_tlisas_management.pojo.Dept;
import com.iheima.web_tlisas_management.pojo.Result;
import com.iheima.web_tlisas_management.service.DeptService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("Query all departments");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    @DeleteMapping
    // When parameter of frontend has the same name as the parameter of backend,
    // the @RequestParam(value = "id", required = false) can be omitted.
    // true is the default value of required. false means the parameter is optional.
    public Result delete(Integer id) {
        log.info("Delete department: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("Add department: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("Get department by id: {}", id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("Update department: {}", dept);                                                                 
        deptService.update(dept);
        return Result.success();
    }

    
}
