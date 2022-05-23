package com.example.joint_development.controller;

import javax.servlet.http.HttpSession;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.domain.RecruitLang;
import com.example.joint_development.form.ProojectMakeForm;
import com.example.joint_development.service.BelongsService;
import com.example.joint_development.service.ProjectsService;
import com.example.joint_development.service.RecruitLangService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private BelongsService belongsService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HttpSession session;

    /**
     * プロジェクト作成
     * @param projectsForm
     * @param recruitLangForm
     * @return
     */
    @PostMapping("/insert")
    public int makeProject(@Validated @RequestBody ProojectMakeForm form,BindingResult bindingResult){
        
        if (bindingResult.hasErrors()) {
            return 1;
        }

        

        //formを各domain形式に変更
        Projects projects=modelMapper.map(form, Projects.class);
        RecruitLang recruitLang=modelMapper.map(form, RecruitLang.class);

        //ログイン情報取得
        if (session.getAttribute("user")==null) {
            return 2;
        }else{
            projects.setUserId(modelMapper.map(session.getAttribute("user"),Projects.class).getUserId());
        }

        //DBにプロジェクト登録
        int projectId=projectsService.makeProject(projects);
        recruitLang.setProjectId(projectId);
        recruitLangService.recruitLangCount(recruitLang);

        //belongsテーブルに登録
        belongsService.newProjectReader(form.getUserId(), projectId);
        
        return 0;
    }
}
