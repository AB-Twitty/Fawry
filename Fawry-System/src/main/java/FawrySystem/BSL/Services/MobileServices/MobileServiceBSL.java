package FawrySystem.BSL.Services.MobileServices;

import org.springframework.stereotype.Service;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.IServiceBSL;
import FawrySystem.BSL.Services.ISimpleServiceFactory;
import FawrySystem.Enums.MobileServiceProviderType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@Service
public class MobileServiceBSL extends IServiceBSL<ProviderFormRequest,ProviderFormRespond> {
	
	private ISimpleServiceFactory serviceFactory;
	
	public MobileServiceBSL() {
		this.serviceFactory = ApplicationContextHolder.getContext().getBean(SimpleMobileServiceFactory.class);
	}

	@Override
	public ProviderFormRespond HandleForm(ProviderFormRequest formRequest) throws EtException{
		return this.serviceFactory
				.GetService((MobileServiceProviderType)formRequest
						.getType()).Handle(formRequest);
	}
	
}
