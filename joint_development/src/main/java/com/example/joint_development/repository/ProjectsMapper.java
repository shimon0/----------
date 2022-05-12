package com.example.joint_development.repository;

import com.example.joint_development.domain.Projects;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectsMapper {
    
    /** プロジェクト作成 */
    public int makeProject(Projects projects);

}
