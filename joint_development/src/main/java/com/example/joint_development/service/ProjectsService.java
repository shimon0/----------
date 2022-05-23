package com.example.joint_development.service;

import java.util.List;

import com.example.joint_development.domain.Projects;
import com.example.joint_development.repository.ProjectsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectsService {
    
    @Autowired
    private ProjectsMapper projectsMapper;

    /** プロジェクト作成 */
    public int makeProject(Projects projects){
        projectsMapper.makeProject(projects);
        return projectsMapper.searchPId();
    }

    /** プロジェクト概要一覧取得 */
    public List<Projects> findProjectList(){
        return projectsMapper.findProjectList();
    }

    /** プロジェクト詳細1件 */
    public Projects findDetailProject(int projectId){
        return projectsMapper.findDetailProject(projectId);
    }
}
