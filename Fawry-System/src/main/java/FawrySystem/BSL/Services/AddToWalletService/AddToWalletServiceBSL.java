package FawrySystem.BSL.Services.AddToWalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.BSL.Services.IServiceBSL;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.ProviderServiceForm.FormRequest.AddToWalletFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@Service
public class AddToWalletServiceBSL extends IServiceBSL<ProviderFormRequest,ProviderFormRespond>{

	@Autowired
	private AddToWalletService addToWalletService;
	
	@Override
	public ProviderFormRespond HandleForm(ProviderFormRequest formRequest) throws EtException {
		return this.addToWalletService.Handle((AddToWalletFormRequest)formRequest);
	}

}
