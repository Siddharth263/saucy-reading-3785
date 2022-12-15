package com.app.model;

public class Sold {
	private int id;
	private int sellerID;
	private int buyerId;
	private int prodID;
	private int price;
	private String status;
	public Sold() {
		super();
	}
	public Sold(int id, int sellerID, int buyerId, int prodID, int price, String status) {
		super();
		this.id = id;
		this.sellerID = sellerID;
		this.buyerId = buyerId;
		this.prodID = prodID;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Sold [id=" + id + ", sellerID=" + sellerID + ", buyerId=" + buyerId + ", prodID=" + prodID + ", price="
				+ price + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
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
