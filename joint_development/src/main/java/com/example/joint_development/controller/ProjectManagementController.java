package com.example.joint_development.controller;

import java.util.List;

import com.example.joint_development.domain.ProjectUser;
import com.example.joint_development.service.BelongsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/pjManagement")
public class ProjectManagementController {

    @Autowired
    private BelongsService belongsService;
    
    /**
     * PJの応募者確認
     * @param projectId
     * @return List<応募者>
     */
    @GetMapping("/applicant")
    public List<ProjectUser> checkApplicant(int projectId){
        return belongsService.checkApplicant(projectId);
    }
}
