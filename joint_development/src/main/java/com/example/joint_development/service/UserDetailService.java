package com.example.joint_development.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.joint_development.domain.Team;
import com.example.joint_development.domain.UserDetail;
import com.example.joint_development.repository.UserDetailMapper;
@Transactional
@Service
public class UserDetailService {
    
    @Autowired
    private  UserDetailMapper mapper;

    /** ユーザー登録 */
    public int setUser(UserDetail user){
        return mapper.insertOne(user);
    }
    
    /** 募集言語登録 */
	public void insertLang(Integer userId,String lang) {
		mapper.insertLang(userId,lang);
	}

    /** ユーザー取得（1件） */
    public UserDetail getUserOne(Integer userId){
        return mapper.findOne(userId);
    }
    
    /** ユーザー取得（1件） */
    public List<Team> findTeam(Integer userId){
        return mapper.findTeam(userId);
    }
    /** ログインユーザー取得 */
    public UserDetail getLoginUser(String email, String password){
        return mapper.findLoginUser(email, password);
    }


}
