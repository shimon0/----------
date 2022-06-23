package com.example.joint_development.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.joint_development.domain.OtherAvailableLang;
import com.example.joint_development.domain.Team;
import com.example.joint_development.domain.UserDetail;

@Mapper
public interface UserDetailMapper {

    /** ユーザー登録 */
    public int insertOne(UserDetail user);

    /** ユーザー言語登録 */
    public void insertLang(@Param("oList") List<OtherAvailableLang> oList);

    /** email重複確認 */
    public Integer confirmUser(@Param("email") String email);

    /** ユーザー取得（1件） */
    public UserDetail findOne(@Param("userId") Integer userId);

    public List<String> findLang(@Param("userId") Integer userId);

    /** ユーザー取得（1件） */
    public List<Team> findTeam(Integer userId);

    public List<Team> findTeam2(Integer userId);

    /** ログインユーザー取得 */
    public UserDetail findLoginUser(String email, String password);

    /** マイページ編集 */
    public void profileEdit(UserDetail userDetail);

    /** 使用可能言語削除 -カラムリセット */
    public void deleteUserLang(int userId);

}
