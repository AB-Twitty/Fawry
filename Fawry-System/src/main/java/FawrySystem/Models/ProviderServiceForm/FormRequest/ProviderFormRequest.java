package FawrySystem.Models.ProviderServiceForm.FormRequest;

import FawrySystem.Enums.ProviderType;

public abstract class ProviderFormRequest {

	private double amount;
	private ProviderType type;
	
	public ProviderFormRequest(double amount, ProviderType type) {
		this.amount = amount;
		this.type = type;
	}
	
	public void setType(ProviderType type) {
		this.type = type;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public ProviderType getType() {
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
}
