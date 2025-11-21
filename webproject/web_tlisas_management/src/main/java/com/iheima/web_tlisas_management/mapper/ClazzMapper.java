package com.iheima.web_tlisas_management.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

import com.iheima.web_tlisas_management.pojo.Cla;


@Mapper
public interface ClazzMapper {

    void insert(Cla clazz);

    List<Cla> list(String name, 
                LocalDate begin, 
                LocalDate end);

    Cla getInfo(Integer id);

    void update(Cla clazz);

    void deleteById(Integer id);

    List<Cla> findAll();
}
