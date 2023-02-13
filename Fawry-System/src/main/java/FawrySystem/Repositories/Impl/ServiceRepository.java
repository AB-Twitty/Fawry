package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Enums.InternetServiceProviderType;
import FawrySystem.Enums.MobileServiceProviderType;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;
import FawrySystem.Repositories.Interfaces.IServiceRepository;

@Repository
public class ServiceRepository implements IServiceRepository{

	private List<ProviderFormRespond> services = new ArrayList<>();
	
	public ServiceRepository() {
		services.add(new ProviderFormRespond(1,10.5,2.5,InternetServiceProviderType.We,13.0));
		services.add(new ProviderFormRespond(2,7.3,2.5,InternetServiceProviderType.We,9.8));
		services.add(new ProviderFormRespond(3,11.0,2.8,MobileServiceProviderType.Vodafone,13.8));
	}
	
	
	@Override
	public ProviderFormRespond Create(ProviderFormRespond service) {
		int id = services.get(services.size()-1).getId();
		id++;
		services.add(new ProviderFormRespond(
				id,
				service.getAmount(),
				service.getFees(),
				service.getType(),
				service.getTotalAmount()));
		return GetById(id);
	}

	@Override
	public ProviderFormRespond GetById(int id) {
		for (ProviderFormRespond service : services) {
			if (id == service.getId())
				return service;
		}
		return null;
	}

}
