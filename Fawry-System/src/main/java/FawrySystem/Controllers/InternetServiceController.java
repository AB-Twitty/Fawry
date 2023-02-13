package FawrySystem.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.InternetServices.InternetServiceBSL;
import FawrySystem.Models.ProviderServiceForm.FormRequest.WeInternetFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@RestController
@RequestMapping("Service/InternetService")
public class InternetServiceController extends ServiceController{

	public InternetServiceController() {
		this.serviceBSL = ApplicationContextHolder.getContext().getBean(InternetServiceBSL.class);
	}
	
	@PostMapping("/ProcessService/We")
	public ResponseEntity<ProviderFormRespond> ProcessWeInternetService(
			@RequestBody WeInternetFormRequest formRequest) {
		return this.ProcessService(formRequest);
	}
}
