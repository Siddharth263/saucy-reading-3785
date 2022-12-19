package com.app.model;

public class Sellers {
	private String seller_name;
	private String seller_mob;
	private String seller_email;
	private String seller_password;
	public Sellers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sellers(String seller_name, String seller_mob, String seller_email, String seller_password) {
		super();
		this.seller_name = seller_name;
		this.seller_mob = seller_mob;
		this.seller_email = seller_email;
		this.seller_password = seller_password;
	}
	@Override
	public String toString() {
		return "Sellers [seller_name=" + seller_name + ", seller_mob=" + seller_mob
				+ ", seller_email=" + seller_email + "]";
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_mob() {
		return seller_mob;
	}
	public void setSeller_mob(String seller_mob) {
		this.seller_mob = seller_mob;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getseller_password() {
		return seller_password;
	}
	public void setSellerseller_password(String seller_password) {
		this.seller_password = seller_password;
	}
}
