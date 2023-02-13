package FawrySystem.BSL.Services.InternetServices;

import org.springframework.stereotype.Service;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.IServiceBSL;
import FawrySystem.BSL.Services.ISimpleServiceFactory;
import FawrySystem.Enums.InternetServiceProviderType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@Service
public class InternetServiceBSL extends IServiceBSL<ProviderFormRequest,ProviderFormRespond>{

	private ISimpleServiceFactory serviceFactory;
	
	public InternetServiceBSL() {
		this.serviceFactory = ApplicationContextHolder.getContext().getBean(SimpleInternetServiceFactory.class);
	}
	
	@Override
	public ProviderFormRespond HandleForm(ProviderFormRequest formRequest) throws EtException {
		return this.serviceFactory
				.GetService((InternetServiceProviderType)formRequest
						.getType()).Handle(formRequest);
	}
	
}
