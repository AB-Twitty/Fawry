package FawrySystem.BSL.Services;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

public interface IService<T extends ProviderFormRequest, R extends ProviderFormRespond> {
	
	public R Handle(T formRequest) throws EtException;
}
