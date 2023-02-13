package FawrySystem.BSL.Services.InternetServices;

import org.springframework.stereotype.Component;

import FawrySystem.BSL.Services.IService;
import FawrySystem.Enums.InternetServiceProviderType;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.WeInternetFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.WeInternetFormRespond;

@Component
public class WeInternetService implements IService<WeInternetFormRequest,WeInternetFormRespond>{

	@Override
	public WeInternetFormRespond Handle(WeInternetFormRequest formRequest) throws EtException {
		String serviceExp1 = "(^010)[0-9]{8}";
		String serviceExp2 = "(^02)[0-9]{8}";
		if (!formRequest.getServiceNum().matches(serviceExp1) && !formRequest.getServiceNum().matches(serviceExp2))
			throw new EtBadRequestException("Invalid Service Number");
		WeInternetFormRespond formRespond = new WeInternetFormRespond(
				formRequest.getAmount(),
				(InternetServiceProviderType)formRequest.getType(),
				formRequest.getServiceNum());
		double totalAmount = formRequest.getAmount() + formRespond.getFees();
		formRespond.setTotalAmount(totalAmount);
		return formRespond;
	}

}
