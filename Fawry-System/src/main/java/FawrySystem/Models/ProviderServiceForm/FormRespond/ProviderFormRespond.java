package FawrySystem.Models.ProviderServiceForm.FormRespond;

import FawrySystem.Enums.ProviderType;

public class ProviderFormRespond {

	private int id;
	private double amount;
	private double fees;
	private double totalAmount;
	private ProviderType type;
	
	public ProviderFormRespond(int id, double amount, double fees, ProviderType type, double totalAmount) {
		this.id = id;
		this.amount = amount;
		this.fees = fees;
		this.type = type;
		this.totalAmount = totalAmount;
	}
	
	public ProviderFormRespond(double amount, double fees, ProviderType type) {
		this.amount = amount;
		this.fees = fees;
		this.type = type;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setType(ProviderType type) {
		this.type = type;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public ProviderType getType() {
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public double getFees() {
		return this.fees;
	}
	
	public double getTotalAmount() {
		return this.totalAmount;
	}
	
	public int getId() {
		return this.id;
	}
}
