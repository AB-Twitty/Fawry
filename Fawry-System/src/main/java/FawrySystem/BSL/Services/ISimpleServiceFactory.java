package FawrySystem.BSL.Services;

import FawrySystem.Enums.ProviderType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

public interface ISimpleServiceFactory {
	
	public IService<ProviderFormRequest,ProviderFormRespond> GetService(ProviderType type) 
			throws EtException;
}
