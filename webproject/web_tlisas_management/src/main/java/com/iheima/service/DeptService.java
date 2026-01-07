package com.iheima.service;

import java.util.List;

import com.iheima.pojo.Dept;


public interface DeptService {

    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);
    
    Dept getInfo(Integer id);

    void update(Dept dept);
    
}
