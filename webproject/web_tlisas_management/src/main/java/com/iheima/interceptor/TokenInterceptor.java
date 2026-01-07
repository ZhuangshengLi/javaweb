package com.iheima.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iheima.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        if(requestURI.contains("/login")) {
            log.info("Login request, pass");
            return true;
        }

        String token = request.getHeader("token");

        if(token == null || token.equals("")) {
            log.info("Token is null or empty");
            response.setStatus(401);
            return false;
        }

        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("Token is invalid");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        log.info("Token is valid");
        return true;
    }
}
