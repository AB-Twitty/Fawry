package FawrySystem.BSL.Services.InternetServices;

import org.springframework.stereotype.Component;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.IService;
import FawrySystem.BSL.Services.ISimpleServiceFactory;
import FawrySystem.Enums.InternetServiceProviderType;
import FawrySystem.Enums.ProviderType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;

@Component
public class SimpleInternetServiceFactory implements ISimpleServiceFactory{

	@Override
	public IService GetService(ProviderType type) 
			throws EtException {
		switch ((InternetServiceProviderType)type) {
		case We:
			return ApplicationContextHolder.getContext().getBean(WeInternetService.class);
		default:
			throw new EtNotFoundException("Type: " + type + "Not Supported");
	}
	}

}
