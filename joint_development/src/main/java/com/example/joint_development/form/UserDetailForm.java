package com.example.joint_development.form;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class UserDetailForm {
	@NotBlank
    private String name;
	@NotBlank
    private String email;
	@NotBlank
    private String password;
	@NotBlank
    private String joiningDate;
	@NotBlank
    private String engineerKinds;
	@NotBlank
    private String experience;
    private String introduction;
    private List<String>otherAvailableLang;
}
