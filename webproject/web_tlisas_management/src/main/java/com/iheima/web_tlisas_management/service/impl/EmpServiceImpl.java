package com.iheima.web_tlisas_management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iheima.web_tlisas_management.mapper.EmpExprMapper;
import com.iheima.web_tlisas_management.mapper.EmpMapper;
import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpExpr;
import com.iheima.web_tlisas_management.pojo.EmpLog;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;
import com.iheima.web_tlisas_management.pojo.PageResult;
import com.iheima.web_tlisas_management.service.EmpLogService;
import com.iheima.web_tlisas_management.service.EmpService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
}
