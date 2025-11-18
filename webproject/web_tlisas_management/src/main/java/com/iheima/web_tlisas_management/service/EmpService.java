package com.iheima.web_tlisas_management.service;

import java.util.List;

import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;
import com.iheima.web_tlisas_management.pojo.PageResult;


public interface EmpService {

    public PageResult<Emp> page(EmpQueryParam empQueryParam);

    public void save(Emp emp) throws Exception;

    public void delete(List<Integer>  ids);

    public Emp getInfo(Integer id);

    public void update(Emp emp);
}
