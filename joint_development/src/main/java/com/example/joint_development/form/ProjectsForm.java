package com.example.joint_development.form;

import java.util.Date;

import com.example.joint_development.domain.RecruitLang;

import lombok.Data;

@Data
public class ProjectsForm {

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
