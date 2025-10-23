package com.itheima.springboot_web_quickstart;
import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("name", "itheima");
        
        response.getWriter().write("<h1>response</h1>");  
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                    .status(401)
                    .header("name", "javaweb")
                    .body("<h1>hello response</h1>");
    }
}
