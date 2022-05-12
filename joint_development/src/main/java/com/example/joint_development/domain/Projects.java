package com.example.joint_development.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Projects {
    
    private Integer projectId;
    private Integer userId;
    private Date postDate;
    private String teamName;
    private String content;
    private Date startDate;
    private Date endDate;
    private Integer frequencyMonth;
    private Integer frequencyWeek;
    private Integer frequencyDate;
    private RecruitLang recruitLang;
}
