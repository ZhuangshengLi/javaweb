package com.itheima.springboot_web_quickstart;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        String method = request.getMethod();
        System.out.println("method = " + method);
        String url = request.getRequestURL().toString();
        System.out.println("url = " + url);
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        String accept = request.getHeader("Accept");
        System.out.println("accept = " + accept);
        return "ok";
    }
}
