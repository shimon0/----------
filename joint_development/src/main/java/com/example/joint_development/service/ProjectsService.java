package com.example.joint_development.service;

import java.util.List;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.domain.RecruitLang;
import com.example.joint_development.repository.BelongsMapper;
import com.example.joint_development.repository.ProjectsMapper;
import com.example.joint_development.repository.RecruitLangMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectsService {
    
    @Autowired
    private ProjectsMapper projectsMapper;
    
    @Autowired
    private RecruitLangMapper recruitLangMapper;

    @Autowired
    private BelongsMapper belongsMapper;

    /** プロジェクト作成 */
    public void makeProject(Projects projects,RecruitLang recruitLang){
        projectsMapper.makeProject(projects);
        recruitLang.setProjectId(projects.getProjectId());
        recruitLangMapper.recruitLangCount(recruitLang);
        belongsMapper.newProjectReader(projects.getUserId(), projects.getProjectId());
    }

    /** プロジェクト概要一覧取得 */
    public List<Projects> findProjectList(){
        return projectsMapper.findProjectList();
    }

    /** プロジェクト詳細1件 */
    public Projects findDetailProject(int projectId){
        return projectsMapper.findDetailProject(projectId);
    }
    
    /** プロジェクト1件アップデート*/
    public void updateProject(Projects projects,RecruitLang recruitLang) {
    	projectsMapper.updateProject(projects);
    	changeRecruitMember(projects.getProjectId(), recruitLang);	
    }
    
    /** 募集人数変更*/
    public void changeRecruitMember(int projectId,RecruitLang recruitLang) {
    	recruitLang.setProjectId(projectId);
    	recruitLangMapper.changeRecruitMember(recruitLang);
    }	
    
}
