package com.iheima.web_tlisas_management.mapper;

import com.iheima.web_tlisas_management.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmpLogMapper {

    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(EmpLog empLog);

}
