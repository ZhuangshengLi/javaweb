package com.iheima.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Data
public class EmpQueryParam {
    Integer page=1;
    Integer pageSize=10;
    String name;
    Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;
}
