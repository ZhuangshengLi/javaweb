package com.iheima.web_tlisas_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iheima.web_tlisas_management.mapper.EmpLogMapper;
import com.iheima.web_tlisas_management.pojo.EmpLog;
import com.iheima.web_tlisas_management.service.EmpLogService;


@Service
public class EmpLogServiceImpl implements EmpLogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
