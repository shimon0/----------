package com.example.joint_development.controller;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.domain.RecruitLang;
import com.example.joint_development.form.ProjectsForm;
import com.example.joint_development.form.RecruitLangForm;
import com.example.joint_development.service.ProjectsService;
import com.example.joint_development.service.RecruitLangService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class MakeProjectController {
    
    @Autowired
    private ProjectsService projectsService;

    @Autowired
    private RecruitLangService recruitLangService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * プロジェクト作成
     * @param projectsForm
     * @param recruitLangForm
     * @return
     */
    @PostMapping("/insert")
    public int makeProject(ProjectsForm projectsForm,RecruitLangForm recruitLangForm){
        
        //formを各domainに変更
        Projects projects=modelMapper.map(projectsForm, Projects.class);
        RecruitLang recruitLang=modelMapper.map(recruitLangForm, RecruitLang.class);

        recruitLang.setProjectId(projectsService.makeProject(projects)); ;
        recruitLangService.recruitLangCount(recruitLang);
        
        return 0;
    }
}
