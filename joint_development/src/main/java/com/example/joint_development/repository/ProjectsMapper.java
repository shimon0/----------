package com.example.joint_development.repository;

import java.util.List;

import com.example.joint_development.domain.Projects;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectsMapper {
    
    /** プロジェクト作成 */
    public int makeProject(Projects projects);

    /** プロジェクト概要一覧取得 */
    public List<Projects> findProjectList();

}
