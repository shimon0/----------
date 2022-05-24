package com.example.joint_development.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class ProojectMakeForm {
    
    @NotEmpty
    private Date postDate;
    @NotEmpty
    private String teamName;
    @NotEmpty
    private String content;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotEmpty
    private String frequencyMonthOrWeek;
    @NotNull
    private Integer frequencyDay;
    @NotEmpty
    private Integer langCl;
    @NotEmpty
    private Integer langWeb;
    @NotEmpty
    private Integer langFr;
    @NotEmpty
    private Integer langMl;
    @NotEmpty
    private Integer langQa;
    
}
