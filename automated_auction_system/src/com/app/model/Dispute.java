package com.app.model;

public class Dispute {
	private int disputeID;
	private int userID;
	private int sellerID;
	private int prodID;
	private String reason;
	private String solution;
	private String status;
	public Dispute() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dispute(int disputeID, int userID, int sellerID, int prodID, String reason, String solution, String status) {
		super();
		this.disputeID = disputeID;
		this.userID = userID;
		this.sellerID = sellerID;
		this.prodID = prodID;
		this.reason = reason;
		this.solution = solution;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Dispute [disputeID=" + disputeID + ", userID=" + userID + ", sellerID=" + sellerID + ", prodID="
				+ prodID + ", reason=" + reason + ", solution=" + solution + ", status=" + status + "]";
	}
	public int getDisputeID() {
		return disputeID;
	}
	public void setDisputeID(int disputeID) {
		this.disputeID = disputeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getSellerID() {
		return sellerID;
	}
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
