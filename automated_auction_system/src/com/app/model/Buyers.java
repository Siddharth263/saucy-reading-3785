package com.app.model;

public class Buyers {
	private int user_id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	public Buyers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyers(int user_id, String name, String email, String mobile, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Buyers [user_id=" + user_id + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
