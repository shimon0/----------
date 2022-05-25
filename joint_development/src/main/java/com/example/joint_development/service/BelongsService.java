package com.example.joint_development.service;

import java.util.List;

import com.example.joint_development.domain.Belongs;
import com.example.joint_development.domain.ProjectUser;
import com.example.joint_development.repository.BelongsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BelongsService {
    
    @Autowired
    private BelongsMapper belongsMapper;

    /** 新規作成時のリーダー登録 */
    public void newProjectReader(int userId,int projectId){
        belongsMapper.newProjectReader(userId, projectId);
    };

    /** ステータス確認 */
    public String confirmStatus(int userId,int projectId){
        return belongsMapper.confirmStatus(userId, projectId);
    }

    /** 参加申請orステータス更新 */
    public void updateStatus(Belongs belongs){
        belongsMapper.updateStatus(belongs);
    }
    /** 応募者確認　List */
    public List<ProjectUser> checkApplicant(int projectId){
        return belongsMapper.checkApplicant(projectId);
    }
}
