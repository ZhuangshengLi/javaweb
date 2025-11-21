package com.iheima.web_tlisas_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iheima.web_tlisas_management.pojo.PageResult;
import com.iheima.web_tlisas_management.pojo.Result;
import com.iheima.web_tlisas_management.pojo.Stu;
import com.iheima.web_tlisas_management.service.StudentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Result save(@RequestBody Stu student) {
        log.info("Save student: {}", student.getNo());
        studentService.save(student);
        return Result.success();
    }

    @GetMapping
    public Result page(String name,
                       Integer degree,
                       Integer clazzId,
                       @RequestParam(defaultValue = "1")
                       Integer page,
                       @RequestParam(defaultValue = "10")
                       Integer pageSize) {
        PageResult<Stu> students = studentService.page(name, degree, clazzId, page, pageSize);
        return Result.success(students);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("Get student by id: {}", id);
        Stu student = studentService.getInfo(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Stu student) {
        log.info("Update student: {}", student.getId());
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("Delete student by ids: {}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("Violation student by id: {}", id);
        studentService.violation(id, score);
        return Result.success();
    }

}
