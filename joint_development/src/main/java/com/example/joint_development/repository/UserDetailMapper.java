package com.example.joint_development.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.joint_development.domain.LangDetail;
import com.example.joint_development.domain.Team;
import com.example.joint_development.domain.UserDetail;

@Mapper
public interface UserDetailMapper {
    
    /** ユーザー登録 */
    public int insertOne(UserDetail user);
    
    /** ユーザー登録 */
    public int insertLang(LangDetail langDetail);

    /** ユーザー取得（1件） */
    public UserDetail findOne(@Param("userId")Integer userId);
    
    /** ユーザー取得（1件） */
    public List<Team> findTeam(Integer userId);
    
    /** ログインユーザー取得 */
    public UserDetail findLoginUser(String email, String password);

   

}
