package com.iheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import com.iheima.utils.CurrentHolder;
import com.iheima.utils.JwtUtils;

import io.jsonwebtoken.Claims;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        if(requestURI.contains("/login")) {
            filterChain.doFilter(request, response);
            log.info("Login request, pass");
            return;
        }

        String token = request.getHeader("token");

        if(token == null || token.equals("")) {
            log.info("Token is null or empty");
            response.setStatus(401);
            return;
        }

        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("Token is invalid");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("Current employee id: {}, saved in thread local", empId);
        } catch (Exception e) {
            log.info("Illegal token, 401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        log.info("Token is valid");
        filterChain.doFilter(request, response);

        CurrentHolder.remove();
    }

}
