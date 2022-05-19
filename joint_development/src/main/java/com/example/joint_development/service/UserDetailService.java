package com.example.joint_development.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.joint_development.domain.LangDetail;
import com.example.joint_development.domain.UserDetail;
import com.example.joint_development.repository.UserDetailMapper;
@Transactional
@Service
public class UserDetailService {
    
    @Autowired
    private  UserDetailMapper mapper;

    /** ユーザー登録 */
    public void setUser(UserDetail user){
        mapper.insertOne(user);
    }
    
    /** 募集言語登録 */
	public void setLangDetail(LangDetail langDetail) {
		mapper.insertLang(langDetail);
	}

    /** ユーザー取得（1件） */
    public UserDetail getUserOne(Integer userId){
        return mapper.findOne(userId);
    }

}
