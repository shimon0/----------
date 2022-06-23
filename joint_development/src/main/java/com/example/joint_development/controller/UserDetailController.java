package com.example.joint_development.controller;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.joint_development.domain.LoginUser;
import com.example.joint_development.domain.Team;
import com.example.joint_development.domain.UserDetail;
import com.example.joint_development.form.ProfileEditForm;
import com.example.joint_development.form.UserDetailForm;
import com.example.joint_development.service.UserDetailService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserDetailController {
    
	@Autowired
    private UserDetailService userService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    /** ユーザー詳細情報取得 */
    @GetMapping("/mypage")
    public UserDetail getUser(int userId){
    	//ユーザー情報取得
    	UserDetail user=userService.getUserOne(userId);
    	user.setOtherAvailableLang(userService.findLang(userId));
    	//チーム情報取得
    	List<Team>team=userService.findTeam(userId);
    	if(team.size()!=0) {
    		user.setTeamList(team);
    	}
    	
    	List<Team>team2=userService.findTeam2(userId);
    	if(team2.size()!=0) {
    		user.setTeam2List(team2);
    	}
    	return user;
    }
    
    /** ユーザー登録処理 */
	@PostMapping("/register")
	@ResponseBody
	public int setUser(@Validated @RequestBody UserDetailForm form, BindingResult bindingResult) {
		System.out.println(form);
    	if (bindingResult.hasErrors()) {
    		//エラーなら空のユーザーを返す
    		return 1;
        }
    	UserDetail user = modelMapper.map(form, UserDetail.class);
		// ユーザー登録
		return userService.setUser(user);

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
	/**
	 * マイページ編集機能
	 * @param form
	 * @return 
	 * 正常　0
	 * 処理エラー 2
	 */
	@PatchMapping("/profileEdit")
	public int profileEdit(@RequestBody ProfileEditForm form){
		UserDetail userDetail=modelMapper.map(form, UserDetail.class);
		userService.profileEdit(userDetail);
		return 0;
	}
}
