package com.iheima.web_tlisas_management.service;

import java.util.List;
import java.util.Map;

import com.iheima.web_tlisas_management.pojo.ClazzCountOption;
import com.iheima.web_tlisas_management.pojo.JobOption;

public interface ReportService {

    public JobOption getEmpJobData();

    public List<Map<String, Object>> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzCountOption getStudentCountData();
}
