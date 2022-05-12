package com.example.joint_development.service;

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
        return projectsMapper.makeProject(projects);
    }
}
