package com.sample.app.service;

import java.util.HashMap;

import com.sample.app.dto.User;



public class LoginService {
	HashMap<String, String> users= new HashMap<String, String>();
	
	public LoginService(){
		users.put("aaa", "awachat");
		users.put("sss", "pk");
		users.put("zzz", "pkawachat");
	}
	
	
	public boolean authenticate(String userId,String pasword){
		
		if(pasword==null || pasword.trim()==" "){
			return false;
		}
				
		return true;
		
	}
	
	public User getUserDetail(String userId){
		User user=new User();
		user.setUsername(users.get(userId));
		user.setUserId(userId);
		return user;
	}

}
