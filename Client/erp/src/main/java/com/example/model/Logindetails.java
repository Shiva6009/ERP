package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Logindetails {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String username;
	private String userpassword;
	private boolean userisactive;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public boolean isUserisactive() {
		return userisactive;
	}
	public void setUserisactive(boolean userisactive) {
		this.userisactive = userisactive;
	}
}
