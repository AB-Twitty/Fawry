package FawrySystem.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.BSL.Services.IServiceBSL;
import FawrySystem.Models.ProviderServiceForm.FormRequest.ProviderFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@RestController
@RequestMapping("/Service")
public abstract class ServiceController {

	protected IServiceBSL<ProviderFormRequest,ProviderFormRespond> serviceBSL;
	
	protected ResponseEntity<ProviderFormRespond> ProcessService(@RequestBody ProviderFormRequest formRequest) {
		return new ResponseEntity<>(
				this.serviceBSL.ProcessService(formRequest),
				HttpStatus.OK);
	}
	
}
