package com.example.joint_development.controller;

import java.util.List;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.service.ProjectsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findProject")
@CrossOrigin
public class FindProjectController {
    
    @Autowired
    private ProjectsService projectsService;

    /**
     * プロジェクト概要一覧取得
     * 全件検索
     * @return
     */
    @GetMapping("/findProjectList")
    public List<Projects> findProjectList(){
        return projectsService.findProjectList();
    }

    /**
     * プロジェクト詳細取得
     * @param projectId
     * @return
     */
    @GetMapping("/detail")
    public Projects findDetailProject(int projectId){
        return projectsService.findDetailProject(projectId);
    }
}
