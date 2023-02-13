package FawrySystem.Models.ProviderServiceForm.FormRespond;

import FawrySystem.Enums.InternetServiceProviderType;

public class WeInternetFormRespond extends ProviderFormRespond{

	private String serviceNum;
	
	public WeInternetFormRespond(double amount, InternetServiceProviderType type, String serviceNum) {
		super(amount, 3.2, type);
		this.serviceNum = serviceNum;
	}

	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	
	public String getServiceNum() {
		return this.serviceNum;
	}
}
