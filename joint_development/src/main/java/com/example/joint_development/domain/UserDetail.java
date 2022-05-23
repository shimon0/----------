package com.example.joint_development.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class UserDetail {
	private Integer userId;
    private String name;
    private String email;
    private String password;
    private Date joiningDate;
    private String engineerKinds;
    private String experience;
    private String introduction;
    private List<String>otherAvailableLang;

    
}
