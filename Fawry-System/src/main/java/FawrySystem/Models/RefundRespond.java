package FawrySystem.Models;

import FawrySystem.Enums.RefundStatus;

public class RefundRespond {
	private int id;
	private int userId;
	private int adminId = 0;
	private int transactionId; 
	private RefundStatus status;
	private double amount;
	
	public RefundRespond(int userId, int transactionId, double amount, RefundStatus status) {
		this.userId = userId;
		this.transactionId = transactionId;
		this.amount = amount;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public RefundStatus getStatus() {
		return status;
	}
	public void setStatus(RefundStatus status) {
		this.status = status;
	}
}
