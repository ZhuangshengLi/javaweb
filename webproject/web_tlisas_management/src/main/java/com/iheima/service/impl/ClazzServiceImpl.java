package com.iheima.service.impl;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iheima.mapper.ClazzMapper;
import com.iheima.pojo.Cla;
import com.iheima.pojo.PageResult;
import com.iheima.service.ClazzService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClazzServiceImpl implements ClazzService{

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public void save(Cla clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public PageResult<Cla> page(String name, 
                                LocalDate begin, 
                                LocalDate end, 
                                Integer page, 
                                Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Cla> clazzs = clazzMapper.list(name, begin, end);
        Page<Cla> p = (Page<Cla>) clazzs;
        return new PageResult<Cla>(p.getTotal(), p.getResult());
    }

    @Override
    public Cla getInfo(Integer id) {
        return clazzMapper.getInfo(id);
    }

    @Override
    public void update(Cla clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Cla> findAll() {
        return clazzMapper.findAll();
    }

}
