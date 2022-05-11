package com.example.joint_development.domain;

import java.util.Date;

import lombok.Data;

@Data
public class JointUser {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private Date jointDate;
    private Integer age;
    private Integer gender;
    private Integer engineerKinds;
    private Integer experience;
    private String introduction;
}
