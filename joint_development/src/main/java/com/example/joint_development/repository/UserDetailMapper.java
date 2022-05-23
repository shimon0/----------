package com.example.joint_development.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.joint_development.domain.LangDetail;
import com.example.joint_development.domain.UserDetail;

@Mapper
public interface UserDetailMapper {
    
    /** ユーザー登録 */
    public int insertOne(UserDetail user);
    
    /** ユーザー登録 */
    public int insertLang(LangDetail langDetail);

    /** ユーザー取得（1件） */
    public UserDetail findOne(@Param("userId")Integer userId);

}
