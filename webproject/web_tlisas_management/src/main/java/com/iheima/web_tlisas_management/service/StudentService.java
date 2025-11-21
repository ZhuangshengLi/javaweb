package com.iheima.web_tlisas_management.service;

import java.util.List;
import java.util.Map;

import com.iheima.web_tlisas_management.pojo.ClazzCountOption;
import com.iheima.web_tlisas_management.pojo.PageResult;
import com.iheima.web_tlisas_management.pojo.Stu;

public interface StudentService {
    void save(Stu student);

    PageResult<Stu> page(String name,
                       Integer degree,
                       Integer clazzId,
                       Integer page,
                       Integer pageSize);

    Stu getInfo(Integer id);

    void update(Stu student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);

    List<Map> getStudentDegreeData();

    ClazzCountOption getStudentClazzData();
}
