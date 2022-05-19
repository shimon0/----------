package com.example.joint_development.controller;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.domain.RecruitLang;
import com.example.joint_development.form.ProojectMakeForm;
import com.example.joint_development.service.ProjectsService;
import com.example.joint_development.service.RecruitLangService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
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
    public int makeProject(@Validated ProojectMakeForm form,BindingResult bindingResult){
        
        if (bindingResult.hasErrors()) {
            return 1;
        }
        //formを各domainに変更
        Projects projects=modelMapper.map(form, Projects.class);
        RecruitLang recruitLang=modelMapper.map(form, RecruitLang.class);

        recruitLang.setProjectId(projectsService.makeProject(projects)); ;
        recruitLangService.recruitLangCount(recruitLang);
        
        return 0;
    }
}
