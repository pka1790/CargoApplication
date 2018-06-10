package com.sample.app.dto;

public class UserData {
	
	private String firstname,lastname,username,password,emailid,birthdate,registeras,mobile;
	private int userId;
	public UserData(String firstname, String lastname, String username, String password, String emailid,
			String birthdate, String registeras,String mobile) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.birthdate = birthdate;
		this.registeras = registeras;
		this.mobile=mobile;
	}
	

	public UserData() {
		// TODO Auto-generated constructor stub
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setRegisteras(String registeras) {
		this.registeras = registeras;
	}

	
	
	public String getMobile() {
		return mobile;
	}
	
	

	public int getUserId() {
		return userId;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getRegisteras() {
		return registeras;
	}


	@Override
	public String toString() {
		return "UserData [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", emailid=" + emailid + ", birthdate=" + birthdate + ", registeras=" + registeras
				+ ", mobile=" + mobile +", userid=" + userId + "]";
	}
	
}
