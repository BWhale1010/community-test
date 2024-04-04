package com.bw.community.user;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class UserDTO {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private String role;
	private Date createDate;
	private String oauth;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOauth() {
		return oauth;
	}
	public void setOauth(String oauth) {
		this.oauth = oauth;
	}

}
