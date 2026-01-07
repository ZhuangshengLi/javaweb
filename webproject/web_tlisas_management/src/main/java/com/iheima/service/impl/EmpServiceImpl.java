package com.iheima.service.impl;

import com.github.pagehelper.Page;

import com.github.pagehelper.PageHelper;
import com.iheima.utils.JwtUtils;

import io.jsonwebtoken.Claims;

import com.iheima.mapper.EmpExprMapper;
import com.iheima.mapper.EmpMapper;
import com.iheima.pojo.Emp;
import com.iheima.pojo.EmpExpr;
import com.iheima.pojo.EmpLog;
import com.iheima.pojo.EmpQueryParam;
import com.iheima.pojo.LoginInfo;
import com.iheima.pojo.PageResult;
import com.iheima.service.EmpLogService;
import com.iheima.service.EmpService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        
        List<Emp> emps = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) emps;    
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp){
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());     
            empMapper.insert(emp);

            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
        EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "Add employee: " + emp.toString());
        empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        try {
            empMapper.deleteByIds(ids);
            empExprMapper.deleteByEmpIds(ids);
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "Delete employees: " + ids.toString());
            empLogService.insertLog(empLog);
        }
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp){
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp e = empMapper.selectByUsernameandPassword(emp);
        if(e != null){
            log.info("Login success: {}", e);

            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }
        return null;
    }
}
