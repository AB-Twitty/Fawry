package FawrySystem.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.MobileServices.MobileServiceBSL;
import FawrySystem.Models.ProviderServiceForm.FormRequest.VodafoneMobileFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@RestController
@RequestMapping("Service/MobileService")
public class MobileServiceController extends ServiceController{
	
	public MobileServiceController() {
		this.serviceBSL = ApplicationContextHolder.getContext().getBean(MobileServiceBSL.class);
	}
	
	@PostMapping("/ProcessService/Vodafone")
	public ResponseEntity<ProviderFormRespond> ProcessVodafoneMobileService(
			@RequestBody VodafoneMobileFormRequest formRequest) {
		return this.ProcessService(formRequest);
	}
}
