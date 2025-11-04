package com.iheima.web_tlisas_management.service.impl;

import com.iheima.web_tlisas_management.service.DeptService;
import com.iheima.web_tlisas_management.pojo.Dept;

import org.springframework.stereotype.Service;
import com.iheima.web_tlisas_management.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
