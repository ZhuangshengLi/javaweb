package com.iheima.controller;

import org.springframework.web.bind.annotation.RestController;

import com.iheima.pojo.Cla;
import com.iheima.pojo.PageResult;
import com.iheima.pojo.Result;
import com.iheima.service.ClazzService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @PostMapping
    public Result save(@RequestBody Cla clazz) {
        log.info("Save class: {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping
    public Result page(String name,
                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate begin,
                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate end,
                    @RequestParam(defaultValue = "1")
                    Integer page,
                    @RequestParam(defaultValue = "10")
                    Integer pageSize
                    ) {
        log.info("Page query all classes", name, begin, end);
        PageResult<Cla> clazzs = clazzService.page(name, begin, end, page, pageSize);
        return Result.success(clazzs);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("Fetch class info by id: {}", id);
        Cla clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Cla clazz) {
        log.info("Update class: {}", clazz.getId());
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("Delete class by id: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll() {
        log.info("List all classes");
        List<Cla> clazzs = clazzService.findAll();
        return Result.success(clazzs);
    }
    
}
