package com.iheima.web_tlisas_management.service;

import java.time.LocalDate;
import java.util.List;

import com.iheima.web_tlisas_management.pojo.Cla;
import com.iheima.web_tlisas_management.pojo.PageResult;

public interface ClazzService {

    void save(Cla clazz);
    
    PageResult<Cla> page(String name, 
                        LocalDate begin, 
                        LocalDate end, 
                        Integer page, 
                        Integer pageSize);

    Cla getInfo(Integer id);

    void update(Cla clazz);

    void deleteById(Integer id);

    List<Cla> findAll();
}
