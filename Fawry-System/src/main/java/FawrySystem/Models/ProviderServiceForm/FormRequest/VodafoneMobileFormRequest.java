package FawrySystem.Models.ProviderServiceForm.FormRequest;

import FawrySystem.Enums.MobileServiceProviderType;

public class VodafoneMobileFormRequest extends ProviderFormRequest {

	private String mobileNum;
	
	public VodafoneMobileFormRequest(double amount, MobileServiceProviderType type, String mobileNum) {
		super(amount,type);
		this.mobileNum = mobileNum;
	}
	
	public void SetMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String GetMobileNum() {
		return this.mobileNum;
	}
	
}
