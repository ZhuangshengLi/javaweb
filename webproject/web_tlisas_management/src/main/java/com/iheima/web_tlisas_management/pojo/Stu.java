package com.iheima.web_tlisas_management.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stu {
    private Integer id;
    private Integer isCollege;
    private Integer violationCount;
    private Integer violationScore;
    private Integer degree;
    private Integer gender;
    private Integer clazzId;
    private String idCard;
    private String no;
    private String name;
    private String address;
    private String clazzName;
    private String phone;
    private LocalDate graduationDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
