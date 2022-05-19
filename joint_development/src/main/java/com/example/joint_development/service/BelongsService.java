package com.example.joint_development.service;

import com.example.joint_development.domain.Belongs;
import com.example.joint_development.repository.BelongsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BelongsService {
    
    @Autowired
    private BelongsMapper belongsMapper;

    /** ステータス確認 */
    public String confirmStatus(int userId,int projectId){
        return belongsMapper.confirmStatus(userId, projectId);
    }

    /** 参加申請orステータス更新 */
    public void updateStatus(Belongs belongs){
        belongsMapper.updateStatus(belongs);
    }
}
