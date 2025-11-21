package com.iheima.web_tlisas_management.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cla {
    private Integer id;
    private Integer masterId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String name;
    private String room;
    private String subject;

    private String masterName;
    private String status;
}
