package com.iheima.service;

import java.util.List;

import com.iheima.pojo.Emp;
import com.iheima.pojo.EmpQueryParam;
import com.iheima.pojo.LoginInfo;
import com.iheima.pojo.PageResult;


public interface EmpService {

    public PageResult<Emp> page(EmpQueryParam empQueryParam);

    public void save(Emp emp) throws Exception;

    public void delete(List<Integer>  ids);

    public Emp getInfo(Integer id);

    public void update(Emp emp);

    public LoginInfo login(Emp emp);
}
