package FawrySystem.Repositories.Interfaces;

import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

public interface IServiceRepository {

	public ProviderFormRespond Create(ProviderFormRespond service);
	
	public  ProviderFormRespond GetById(int id);
}
