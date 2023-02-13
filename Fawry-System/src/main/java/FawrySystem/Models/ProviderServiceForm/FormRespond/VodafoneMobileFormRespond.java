package FawrySystem.Models.ProviderServiceForm.FormRespond;

import FawrySystem.Enums.MobileServiceProviderType;

public class VodafoneMobileFormRespond extends ProviderFormRespond{

	private String mobileNum;
	
	public VodafoneMobileFormRespond(double amount, MobileServiceProviderType type, String mobileNum) {
		super(amount, 2.5, type);
		this.mobileNum = mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getMobileNum() {
		return this.mobileNum;
	}
}
