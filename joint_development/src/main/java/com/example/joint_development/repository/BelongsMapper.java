package com.example.joint_development.repository;

import com.example.joint_development.domain.Belongs;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BelongsMapper {

    /** ステータス確認 */
    public String confirmStatus(int userId,int projectId);

    /** 参加申請orステータス更新 */
    public void updateStatus(Belongs belongs);

}
