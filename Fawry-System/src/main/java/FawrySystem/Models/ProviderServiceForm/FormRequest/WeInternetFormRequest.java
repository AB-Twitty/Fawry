package FawrySystem.Models.ProviderServiceForm.FormRequest;

import FawrySystem.Enums.InternetServiceProviderType;

public class WeInternetFormRequest extends ProviderFormRequest{

	private String serviceNum;
	
	public WeInternetFormRequest(double amount, InternetServiceProviderType type, String serviceNum) {
		super(amount, type);
		this.serviceNum = serviceNum;
	}
	
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	
	public String getServiceNum() {
		return this.serviceNum;
	}

}
