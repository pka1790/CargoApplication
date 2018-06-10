package com.sample.dao;

import java.util.List;

import com.sample.app.dto.UserData;

public interface UserDao {

	
	int insertUserData(String dbDriver,
			String connectionUrl, String userName, String password,String dbQuery,UserData userData);
	
}
