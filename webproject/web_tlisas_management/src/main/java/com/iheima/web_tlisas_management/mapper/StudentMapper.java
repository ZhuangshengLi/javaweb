package com.iheima.web_tlisas_management.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.iheima.web_tlisas_management.pojo.Stu;

@Mapper
public interface StudentMapper {

    void insert(Stu student);

    List<Stu> list(String name,
                       Integer degree,
                       Integer clazzId);

    Stu getById(Integer id);

    void update(Stu student);

    void delete(List<Integer> ids);

    void updateViolation(Integer id, Integer score);

    List<Map> countStudentDegreeData();

    List<Map<String,Object>> getStudentCount();

    Integer countByClazzId(Integer id);

    void insertBatch(List<Stu> studentList);

}
