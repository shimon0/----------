package com.example.joint_development.repository;

import java.util.List;

import com.example.joint_development.domain.Projects;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectsMapper {
    
    /** プロジェクト作成 */
    public void makeProject(Projects projects);

    /** 最新プロジェクトID検索 */
    public int searchPId();

    /** プロジェクト概要一覧取得 */
    public List<Projects> findProjectList();

    /** プロジェクト詳細1件取得 */
    public Projects findDetailProject(int projectId);

}
