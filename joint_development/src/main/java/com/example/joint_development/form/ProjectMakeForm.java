package com.example.joint_development.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class ProjectMakeForm {
    
    @NotNull
    private Integer userId;
    @NotNull
    private String teamName;
    @NotNull
    private String content;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull
    private String frequencyMonthOrWeek;
    @NotNull
    private Integer frequencyDay;
    @NotNull
    private Integer langCl;
    @NotNull
    private Integer langWeb;
    @NotNull
    private Integer langFr;
    @NotNull
    private Integer langMl;
    @NotNull
    private Integer langQa;
    
}
