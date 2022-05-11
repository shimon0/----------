package com.example.joint_development.service;

import java.util.List;

import com.example.joint_development.domain.JointUser;
import com.example.joint_development.repository.JointUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class JointUserService {
    
    @Autowired
    private  JointUserMapper mapper;

    /** ユーザー登録 */
    public void signup(JointUser user){
        mapper.insertOne(user);
    }

    /** ログインユーザー取得 */
    public JointUser getLoginUser(String userId){
        return mapper.finndLoginUser(userId);
    }

    /** ユーザー取得 */
    public List<JointUser> getUsers(JointUser user){
        return mapper.findMany(user);
    }

    /** ユーザー取得（1件） */
    public JointUser getUserOne(String userId){
        return mapper.finfOne(userId);
    }

    /** パスワード更新（1件） */
    public void updateUserOne(String userId,String password){
        mapper.updateOne(userId, password);
    }

    /** ユーザー削除(1件) */
    public void deleteUserOne(String userId){
        mapper.deleteOne(userId);
    }
}
