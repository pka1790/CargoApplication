package com.sample.app.service;

import com.sample.app.dto.UserData;
import com.sample.dao.UserDaoIimpl;

public class UserService {

	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String CONN_URL="jdbc:mysql://localhost:3306/cargo_buisness";
	private static final String USERNAME="root";
	private static final String PASS="root";	
	private static final String INS_QUERY="INSERT INTO USERS"+ "(USERNAME,FIRSTNAME,LASTNAME,PASSWORD,EMAIL_ID,MOBILE,BIRTHDATE,REGISTERAS) VALUES"+ "(?,?,?,?,?,?,?,?)";
	private static final String GET_CREDS="SELECT username,firstname,lastname,password,email_id,mobile,birthdate,registeras from users where username = "+"?";

	public boolean registerUser(UserData userData) {
		UserDaoIimpl daoIimpl= new UserDaoIimpl();
		if(userData!=null){
			if(daoIimpl.insertUserData(DB_DRIVER, CONN_URL, USERNAME, PASS, INS_QUERY,userData)!=0){
				return true;
			}
		}
		return false;

	}

	public UserData logIn(String username2) {
		UserDaoIimpl daoImpl= new UserDaoIimpl();
		if(username2!=null){
			UserData data= daoImpl.getCreds(DB_DRIVER, CONN_URL, USERNAME, PASS, GET_CREDS,username2);
			return data;
		}
		return null;	
	}




}
