package com.iheima.service;

import java.util.List;
import java.util.Map;

import com.iheima.pojo.ClazzCountOption;
import com.iheima.pojo.JobOption;

public interface ReportService {

    public JobOption getEmpJobData();

    public List<Map<String, Object>> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzCountOption getStudentCountData();
}
