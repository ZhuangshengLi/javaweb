package com.iheima.web_tlisas_management.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;

@Mapper
public interface EmpMapper {

    public List<Emp> list(EmpQueryParam empQueryParam);

    public void insert(Emp emp);

    public void deleteByIds(List<Integer> ids);

    public Emp getById(Integer id);

    public void updateById(Emp emp);

    public List<Map<String, Object>> countEmpJobData();

    public List<Map<String, Object>> countEmpGenderData();
}
