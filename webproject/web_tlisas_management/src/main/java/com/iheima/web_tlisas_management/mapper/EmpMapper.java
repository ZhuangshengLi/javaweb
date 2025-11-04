package com.iheima.web_tlisas_management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;

@Mapper
public interface EmpMapper {

    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Emp emp);
}
