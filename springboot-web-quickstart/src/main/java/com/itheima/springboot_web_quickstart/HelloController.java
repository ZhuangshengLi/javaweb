package com.itheima.springboot_web_quickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("name = " + name);
        return "Hello, " + name;
    }
}
