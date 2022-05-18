package com.example.joint_development.repository;

import com.example.joint_development.domain.Belongs;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BelongsMapper {
    
    /** 参加申請 データ登録 */
    public void joinProject(int userId,int projectId);

    /** ステータス確認 */
    public String confirmStatus(int userId,int projectId);

    /** ステータス更新 */
    public void updateStatus(Belongs belongs);

}
