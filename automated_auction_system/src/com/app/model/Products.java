package com.app.model;

public class Products {
	private int prodId;
	private int sellerId;
	private String prodName;
	private String category;
	private int price;
	private String status;
	public Products(int sellerId, String prodName, String category, int price, String status) {
		super();
		this.sellerId = sellerId;
		this.prodName = prodName;
		this.category = category;
		this.price = price;
		this.status = status;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Products [prodId=" + prodId + ", sellerId=" + sellerId + ", prodName=" + prodName + ", category="
				+ category + ", price=" + price + ", status=" + status + "]";
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
