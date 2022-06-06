package com.example.joint_development.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class ProjectMakeForm {
    
    @NotBlank
    private String userId;
    @NotBlank
    private String teamName;
    @NotBlank
    private String content;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private String frequencyMonthOrWeek;
    @NotBlank
    private String frequencyDay;
    @NotBlank
    private String langCl;
    @NotBlank
    private String langWeb;
    @NotBlank
    private String langFr;
    @NotBlank
    private String langMl;
    @NotBlank
    private String langQa;
    
}
