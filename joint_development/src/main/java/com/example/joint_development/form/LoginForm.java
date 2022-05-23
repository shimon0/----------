package com.example.joint_development.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class LoginForm {
	@Email(message="Eメールの形式が不正です")
	private String email;
	@Size(min=4, max=16, message="パスワードは4文字以上16文字以下で記入してください")
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
