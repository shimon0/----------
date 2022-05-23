package com.example.joint_development.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.joint_development.domain.JointUser;
import com.example.joint_development.domain.LoginUser;
import com.example.joint_development.form.LoginForm;
import com.example.joint_development.service.JointUserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@Slf4j
public class JointUserdetailsController {
    
    @Autowired
    private JointUserService userService;
    
    @Autowired
    private HttpSession session;
    
    
    @ModelAttribute
    public LoginForm setupLoginForm() {
    	return new LoginForm();
    }
    
    /** ユーザー詳細情報取得 */
   //返り値が0の場合は正常、1の場合はエラーとしている
    @GetMapping("/detail")
    public int getUser(@RequestParam("userId") Integer userId){
    	if(session.getAttribute("user") == null) {
    		//ログインしていなかった場合の処理を書く
    		return 1;
    	}
        //ユーザー1件取得
        JointUser user=userService.getUserOne(userId);

        return 0;
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
    //返り値が0の場合は正常、1の場合はエラーとしている
    @PostMapping("/login")
    public int getLoginUser(@RequestBody LoginUser loginUser) {
		/*
		 * if(result.hasErrors()) { //入力値エラーの際の処理を書く
		 * System.out.println("ログインできませんでした。"); return 1; }
		 */
    	
    	
    	
    	//loginUser.setEmail(email);
    	//loginUser.setPassword(password);
    	
    	//ログインユーザ情報取得
    	JointUser user = userService.getLoginUser(loginUser.getEmail(), loginUser.getPassword());
    	if(user == null) {
    		System.out.println("ログインできませんでした");
    		return 1;
    	}
    	
    	System.out.println("ログインできました");
    	session.setAttribute("user", user);
    	return 0;
    }
    
    /**ログアウトする*/
    @GetMapping("/logout")
    public int logout() {
    	if(session.getAttribute("user") == null) {
    		System.out.println("ログインしていません");
    		return 1;
    	}else {
    		System.out.println("ログアウトしました。");
    		session.invalidate();
    	}
    	
    	return 0;
    }
        
    
}

