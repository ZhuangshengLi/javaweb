package com.iheima.web_tlisas_management.service;

import com.iheima.web_tlisas_management.pojo.Emp;
import com.iheima.web_tlisas_management.pojo.EmpQueryParam;
import com.iheima.web_tlisas_management.pojo.PageResult;


public interface EmpService {

    public PageResult<Emp> page(EmpQueryParam empQueryParam);

    public void save(Emp emp) throws Exception;
}
