package com.example.joint_development.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.joint_development.domain.OtherAvailableLang;
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
        if (mapper.confirmUser(user.getEmail())!=null) {
            return 2;
        }
        mapper.insertOne(user);
        if (user.getOtherAvailableLang()!=null) {
            insertLang(user);            
        }
        return 0;
    }
    
    /** 募集言語登録 */
	public void insertLang(UserDetail user) {
        List<OtherAvailableLang> otherAvailableLangs=new ArrayList<>();
        for (String otherLang : user.getOtherAvailableLang()) {
            OtherAvailableLang oaLang=new OtherAvailableLang();
            oaLang.setUserId(user.getUserId());
            oaLang.setOtherAvailableLang(otherLang);
            otherAvailableLangs.add(oaLang);
        }
		mapper.insertLang(otherAvailableLangs);
	}

    /** ユーザー取得（1件） */
    public UserDetail getUserOne(Integer userId){
        return mapper.findOne(userId);
    }
    
    public List<String> findLang(Integer userId){
        return mapper.findLang(userId);
    }
    
    /** ユーザー取得（1件） */
    public List<Team> findTeam(Integer userId){
        return mapper.findTeam(userId);
    }
    
    public List<Team> findTeam2(Integer userId){
        return mapper.findTeam2(userId);
    }
    /** ログインユーザー取得 */
    public UserDetail getLoginUser(String email, String password){
        return mapper.findLoginUser(email, password);
    }

    /** マイページ編集 */
    public void profileEdit(UserDetail userDetail){
        mapper.profileEdit(userDetail);
        if (userDetail.getOtherAvailableLang().size() !=0) {
            mapper.deleteUserLang(userDetail.getUserId());
            //* 言語追加機能 */
            insertLang(userDetail);
        }
    }


}
