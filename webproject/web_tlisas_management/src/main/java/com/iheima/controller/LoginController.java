package com.iheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iheima.pojo.Emp;
import com.iheima.pojo.LoginInfo;
import com.iheima.pojo.Result;
import com.iheima.service.EmpService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("Login: {}", emp);
        LoginInfo info = empService.login(emp);
        if(info != null){
            return Result.success(info);
        }else{
            return Result.error("Login failed");
        }
    }
    
}