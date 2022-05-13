package com.example.joint_development.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.joint_development.domain.JointUser;
import com.example.joint_development.service.JointUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class JointUserdetailsController {
    
    @Autowired
    private JointUserService userService;

    /** ユーザー詳細情報取得 */
    @GetMapping("/detail")
    public JointUser getUser(@RequestParam("userId") Integer userId){

        //ユーザー1件取得
        JointUser user=userService.getUserOne(userId);

        return user;
    }
    

    /** パスワード更新 */
    @PostMapping("/password")
    public int updatePassword(@RequestParam("userId")String userId,@RequestParam("password")String password){
        try {
            //パスワード更新
            userService.updateUserOne(userId, password);
        } catch (Exception e) {
            //lombokのlogメゾット
            log.error("パスワード更新でエラー", e);
        }
        

        return 0;
    }

    /** ユーザー削除（1件） */
    @PostMapping("/delete")
    public int deleteUserOne(String userId){
        
        //削除処理
        userService.deleteUserOne(userId);

        return 0;
    }
    
    /** ログイン情報取得*/
    @GetMapping("/login")
    public JointUser getLoginUser(String userId) {
    	//ログインユーザ情報取得
    	JointUser user = userService.getLoginUser(userId);
    	System.out.println(user);
    	return user;
    }
}

