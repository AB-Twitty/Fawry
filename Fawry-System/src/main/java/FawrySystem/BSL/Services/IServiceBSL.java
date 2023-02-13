package FawrySystem.BSL.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;
import FawrySystem.Repositories.Interfaces.IServiceRepository;

@Service
public abstract class IServiceBSL<T extends ProviderFormRequest, R extends ProviderFormRespond> {
	
	@Autowired
	private IServiceRepository serviceRepo;
	
	public abstract R HandleForm(T formRequest) throws EtException;
	
	public R ProcessService(T formRequest) throws EtException {
		R formRespond = HandleForm(formRequest);
		
		ProviderFormRespond form = serviceRepo.Create(new ProviderFormRespond(
				0,
				formRespond.getAmount(),
				formRespond.getFees(),
				formRespond.getType(),
				formRespond.getTotalAmount()));
		if (form==null)
			throw new EtBadRequestException("Bad Request");
		
		return formRespond;
	}
	
	public ProviderFormRespond GetServiceById(int id) throws EtException {
		ProviderFormRespond form = this.serviceRepo.GetById(id);
		if (form==null)
			throw new EtNotFoundException("Not Found");
		return form;
	}

}
