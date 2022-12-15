package com.app.model;

public class Products {
	private int prod_id;
	private String prod_name;
	private int seller_id;
	private int price;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int prod_id, String prod_name, int seller_id, int price) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.seller_id = seller_id;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", seller_id=" + seller_id + ", price="
				+ price + "]";
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
