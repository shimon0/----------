package com.example.joint_development.form;

import java.util.Date;

import lombok.Data;
@Data
public class ProojectMakeForm {
    
    private Integer userId;
    private Date postDate;
    private String teamName;
    private String content;
    private Date startDate;
    private Date endDate;
    private String frequencyMonthOrWeek;
    private Integer frequencyDay;
    private Integer langCl;
    private Integer langWeb;
    private Integer langFr;
    private Integer langMl;
    private Integer langQa;
    
}
