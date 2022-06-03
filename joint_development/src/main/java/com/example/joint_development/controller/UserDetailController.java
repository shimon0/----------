package com.example.joint_development.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.joint_development.domain.LoginUser;
import com.example.joint_development.domain.Team;
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
    @PostMapping("/mypage")
    public UserDetail getUser(@RequestBody UserDetail users){
    	
    	//ユーザー情報取得
    	UserDetail user=userService.getUserOne(users.getUserId());
    	user.setOtherAvailableLang(userService.findLang(users.getUserId()));
    	//チーム情報取得
    	List<Team>team=userService.findTeam(users.getUserId());
    	if(team.size()!=0) {
    		user.setTeamList(team);
    	}
    	
    	List<Team>team2=userService.findTeam2(users.getUserId());
    	if(team2.size()!=0) {
    		user.setTeam2List(team2);
    	}
    	return user;
    }
    
    /** ユーザー登録処理 */
	@PostMapping("/register")
	@ResponseBody
	public void setUser(@RequestBody UserDetail user) {

		UserDetail user1 = user;
		// ユーザー登録
		userService.setUser(user1);
		// 言語登録
		if(user1.getOtherAvailableLang()!= null) {
			for(String lang : user1.getOtherAvailableLang()) {
				userService.insertLang(user1.getUserId(),lang);
			}
		}

	}
    
    /** ログイン情報取得*/
    //返り値が0の場合は正常、1の場合はエラーとしている
    @PostMapping("/login")
    public UserDetail findLoginUser(@RequestBody LoginUser loginUser) {
    	//UserDetail userDetail = new UserDetail();
		/*
		 * if(result.hasErrors()) { //入力値エラーの際の処理を書く
		 * System.out.println("ログインできませんでした。"); return 1; }
		 */
    	
    	
    	
    	//loginUser.setEmail(email);
    	//loginUser.setPassword(password);
    	
    	//ログインユーザ情報取得
    	UserDetail user = userService.getLoginUser(loginUser.getEmail(), loginUser.getPassword());
    	if(user == null) {
    		System.out.println("ログインできませんでした");
    		//user.setEmail(null);
    		//System.out.println(user.getEmail());
    		return user;
    	}
    	
    	System.out.println("ログインできました");
    	System.out.println(user.getName());
    	//session.setAttribute("user", user);
    	return user;
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
