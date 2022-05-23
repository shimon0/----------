package com.example.joint_development.domain;

import java.util.Date;
import java.util.List;

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
    private String frequencyMonthOrWeek;
    private Integer frequencyDay;
    private RecruitLang recruitLang;
    private List<ProjectUser> projectUserList;
    
}
