package com.app.model;

public class Buyers {
	private String name;
	private String email;
	private String mobile;
	private String password;
	public Buyers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buyers( String name, String email, String mobile, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Buyers [name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + "]";
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
