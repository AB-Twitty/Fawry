package FawrySystem.BSL.Services.MobileServices;

import org.springframework.stereotype.Component;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.IService;
import FawrySystem.BSL.Services.ISimpleServiceFactory;
import FawrySystem.Enums.MobileServiceProviderType;
import FawrySystem.Enums.ProviderType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;

@Component
public class SimpleMobileServiceFactory implements ISimpleServiceFactory{

	@Override
	public IService GetService(ProviderType type)
			throws EtException {
		switch ((MobileServiceProviderType)type) {
			case Vodafone:
				return ApplicationContextHolder.getContext().getBean(VodafoneMobileService.class);
			default:
				throw new EtNotFoundException("Type: " + type + "Not Supported");
		}
	}

	

}
