package com.sample.dao;

import java.sql.*;


import com.sample.app.dto.UserData;

public class UserDaoIimpl implements UserDao{

	@Override
	public int insertUserData(String dbDriver, String connectionUrl, String userName, String password,
			String dbQuery, UserData userData) {

		PreparedStatement pstmt = null;
		int result=0;
		Connection conn = getConnection(dbDriver,connectionUrl,userName,password);
		try {
			//INSERT INTO USERS"+ "(USERNAME,FIRSTNAME,LASTNAME,PASSWORD,EMAIL_ID,MOBILE,BIRTHDATE,REGISTERAS) VALUES"+ "(?,?,?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(dbQuery);
			pstmt.setString(1,userData.getUsername());
			pstmt.setString(2, userData.getFirstname());
			pstmt.setString(3, userData.getLastname());
			pstmt.setString(4, userData.getPassword());
			pstmt.setString(5, userData.getEmailid());
			pstmt.setString(6, userData.getMobile());
			pstmt.setString(7, userData.getBirthdate());
			pstmt.setString(8, userData.getRegisteras());
			result=	pstmt.executeUpdate();
			if(result!=0){
				return result;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			closeAll(conn,pstmt);
		}

		return result;
	}

	private void closeAll(Connection conn, PreparedStatement pstmt) {
		try {

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


	}

	private Connection getConnection(String dbDriver, String connectionUrl, String userName, String password) {
		System.out.println("DB connection...");
		Connection connection=null;	
		try {
			Class.forName(dbDriver);
			connection=DriverManager.getConnection(connectionUrl, userName, password);
			if(!connection.equals(null)){
				System.out.println(" Connection Success.");
				return connection;		
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public UserData getCreds(String dbDriver, String connUrl, String username, String pass, String getQuery,
			String username2) {

		PreparedStatement pstmt = null;
		UserData userdata=null;
		ResultSet rs=null;
		Connection conn = getConnection(dbDriver,connUrl,username,pass);

		//"SELECT username,firstname,lastname,password,email_id,mobile,birthdate,registeras from users"+ "WHERE USERNAME = ?";
		try {
			pstmt= conn.prepareStatement(getQuery);
			pstmt.setString(1, username2);
			rs= pstmt.executeQuery();
			if(!rs.equals(null)){
				while(rs.next()){
					System.out.println(rs.getString(1)+" "+rs.getString(2));
					userdata= new UserData();
					userdata.setUsername(rs.getString(1));
					userdata.setFirstname(rs.getString(2));
					userdata.setLastname(rs.getString(3));
					userdata.setPassword(rs.getString(4));
					userdata.setEmailid(rs.getString(5));
					userdata.setMobile(rs.getString(6));
					userdata.setBirthdate(rs.getString(7));
					userdata.setRegisteras(rs.getString(8));
					
				}
				return userdata;
			}else
				return userdata;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				closeAll(conn, pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return userdata;
	}

}
