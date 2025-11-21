package com.iheima.web_tlisas_management.service.impl;

import com.iheima.web_tlisas_management.service.StudentService;
import com.iheima.web_tlisas_management.pojo.Stu;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iheima.web_tlisas_management.mapper.StudentMapper;
import com.iheima.web_tlisas_management.pojo.ClazzCountOption;
import com.iheima.web_tlisas_management.pojo.PageResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void save(Stu student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public PageResult<Stu> page(String name,
                       Integer degree,
                       Integer clazzId,
                       Integer page,
                       Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Stu> students = studentMapper.list(name, degree, clazzId);
        Page<Stu> p = (Page<Stu>) students;
        return new PageResult<Stu>(p.getTotal(), p.getResult());
    }

    @Override
    public Stu getInfo(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Stu student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzCountOption getStudentClazzData() {
        List<Map<String, Object>> countList = studentMapper.getStudentCount();
        if(!CollectionUtils.isEmpty(countList)){
            List<Object> clazzList = countList.stream().map(map -> {
                return map.get("cname");
            }).toList();

            List<Object> dataList = countList.stream().map(map -> {
                return map.get("scount");
            }).toList();

            return new ClazzCountOption(clazzList, dataList);
        }
        return null;
    }
}
