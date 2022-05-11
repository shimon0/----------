package com.example.joint_development.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.joint_development.domain.JointUser;

@Mapper
public interface JointUserMapper {
    
    /** ユーザー登録 */
    public int insertOne(JointUser user);

    /** ログインユーザー取得 */
    public JointUser findLoginUser(String userId);

    /** ユーザー情報取得 */
    public List<JointUser> findMany(JointUser user);

    /** ユーザー取得（1件） */
    public JointUser findOne(@Param("userId")Integer userId);

    /** パスワード更新 */
    public void updateOne(@Param("userId")String userId,@Param("password")String password);

    /** ユーザー削除（1件） */
    public void deleteOne(@Param("userId")String userId);
}
