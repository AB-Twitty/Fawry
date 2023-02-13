package FawrySystem.BSL.Services.MobileServices;

import org.springframework.stereotype.Component;

import FawrySystem.BSL.Services.IService;
import FawrySystem.Enums.MobileServiceProviderType;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.VodafoneMobileFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.VodafoneMobileFormRespond;

@Component
public class VodafoneMobileService implements IService<VodafoneMobileFormRequest,VodafoneMobileFormRespond>{

	@Override
	public VodafoneMobileFormRespond Handle(VodafoneMobileFormRequest formRequest) throws EtException{
		String numExp = "(^010)[0-9]{8}";
		if (!formRequest.GetMobileNum().matches(numExp))
			throw new EtBadRequestException("Invalid Mobile Number");
		VodafoneMobileFormRespond formRespond = new VodafoneMobileFormRespond(
				formRequest.getAmount(),
				(MobileServiceProviderType)formRequest.getType(),
				formRequest.GetMobileNum());
		double totalAmount = formRequest.getAmount() + formRespond.getFees();
		formRespond.setTotalAmount(totalAmount);
		return formRespond;
	}

	
}
