package com.example.joint_development.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class ProfileEditForm {

    @NotNull
    private Integer userId;
    private String name;
    private String engineerKinds;
    private String experience;
    private String introduction;
    private List<String> otherAvailableLang;
}
