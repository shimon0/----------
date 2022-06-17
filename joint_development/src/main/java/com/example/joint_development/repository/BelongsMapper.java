package com.example.joint_development.repository;

import java.util.List;

import com.example.joint_development.domain.Belongs;
import com.example.joint_development.domain.ProjectUser;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BelongsMapper {

    /** 新規作成時のリーダー登録 */
    public void newProjectReader(int userId,int projectId);

    /** 参加申請orステータス更新 */
    public void updateStatus(Belongs belongs);

    /** 応募者確認　List */
    public List<ProjectUser> checkApplicant(int projectId);

}
