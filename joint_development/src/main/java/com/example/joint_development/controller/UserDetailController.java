package com.example.joint_development.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.joint_development.domain.JointUser;
import com.example.joint_development.domain.LangDetail;
import com.example.joint_development.domain.LoginUser;

import com.example.joint_development.domain.UserDetail;
import com.example.joint_development.service.UserDetailService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserDetailController {
    
    @Autowired
    private UserDetailService userService;
    
    @Autowired
    private HttpSession session;
    
    /** ユーザー詳細情報取得 */
    @PostMapping("/detail")
    public UserDetail getUser(@RequestParam("userId") Integer userId){

        //ユーザー1件取得
    	return userService.getUserOne(userId);
    	
    }
    
    /** ユーザー登録処理 */
    @PostMapping("/register")
    @ResponseBody
    public void setUser(@RequestBody UserDetail user){
    	
    	UserDetail user1=user;
    	//ユーザー登録
    	userService.setUser(user1);
    	
    	/*
    	//募集言語登録
    	LangDetail langDetail = new LangDetail();
    	langDetail.setUserId(user1.getUserId());
		if (!user1.getOtherAvailableLang().get(0).equals(null)) {
			langDetail.setLangOther1(user1.getOtherAvailableLang().get(0));
		}
		if (!user1.getOtherAvailableLang().get(1).equals(null)) {
			langDetail.setLangOther2(user1.getOtherAvailableLang().get(1));
		}
		if (!user1.getOtherAvailableLang().get(2).equals(null)) {
			langDetail.setLangOther3(user1.getOtherAvailableLang().get(2));
		}
		if (!user1.getOtherAvailableLang().get(3).equals(null)) {
			langDetail.setLangOther4(user1.getOtherAvailableLang().get(3));
		}
		if (!user1.getOtherAvailableLang().get(4).equals(null)) {
			langDetail.setLangOther5(user1.getOtherAvailableLang().get(4));
		}
		if (!user1.getOtherAvailableLang().get(5).equals(null)) {
			langDetail.setLangOther6(user1.getOtherAvailableLang().get(5));
		}
		if (!user1.getOtherAvailableLang().get(6).equals(null)) {
			langDetail.setLangOther7(user1.getOtherAvailableLang().get(6));
		}
		if (!user1.getOtherAvailableLang().get(7).equals(null)) {
			langDetail.setLangOther8(user1.getOtherAvailableLang().get(7));
		}
		if (!user1.getOtherAvailableLang().get(8).equals(null)) {
			langDetail.setLangOther9(user1.getOtherAvailableLang().get(8));
		}
		if (!user1.getOtherAvailableLang().get(9).equals(null)) {
			langDetail.setLangOther10(user1.getOtherAvailableLang().get(9));
		}
		if (!user1.getOtherAvailableLang().get(10).equals(null)) {
			langDetail.setLangOther11(user1.getOtherAvailableLang().get(10));
		}
		if (!user1.getOtherAvailableLang().get(11).equals(null)) {
			langDetail.setLangOther12(user1.getOtherAvailableLang().get(11));
		}
		if (!user1.getOtherAvailableLang().get(12).equals(null)) {
			langDetail.setLangOther13(user1.getOtherAvailableLang().get(12));
		}
		if (!user1.getOtherAvailableLang().get(13).equals(null)) {
			langDetail.setLangOther14(user1.getOtherAvailableLang().get(13));
		}
		if (!user1.getOtherAvailableLang().get(14).equals(null)) {
			langDetail.setLangOther15(user1.getOtherAvailableLang().get(14));
		}
		if (!user1.getOtherAvailableLang().get(15).equals(null)) {
			langDetail.setLangOther16(user1.getOtherAvailableLang().get(15));
		}
		if (!user1.getOtherAvailableLang().get(16).equals(null)) {
			langDetail.setLangOther17(user1.getOtherAvailableLang().get(16));
		}
		if (!user1.getOtherAvailableLang().get(17).equals(null)) {
			langDetail.setLangOther18(user1.getOtherAvailableLang().get(17));
		}
		if (!user1.getOtherAvailableLang().get(18).equals(null)) {
			langDetail.setLangOther19(user1.getOtherAvailableLang().get(18));
		}
		if (!user1.getOtherAvailableLang().get(19).equals(null)) {
			langDetail.setLangOther20(user1.getOtherAvailableLang().get(19));
		}

    	userService.setLangDetail(langDetail);
    	
    	*/
    	
    }
    
    /** ログイン情報取得*/
    //返り値が0の場合は正常、1の場合はエラーとしている
    @PostMapping("/login")
    public int findLoginUser(@RequestBody LoginUser loginUser) {
		/*
		 * if(result.hasErrors()) { //入力値エラーの際の処理を書く
		 * System.out.println("ログインできませんでした。"); return 1; }
		 */
    	
    	
    	
    	//loginUser.setEmail(email);
    	//loginUser.setPassword(password);
    	
    	//ログインユーザ情報取得
    	UserDetail user = userService.getLoginUser(loginUser.getEmail(), loginUser.getPassword());
    	if(user == null) {
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
