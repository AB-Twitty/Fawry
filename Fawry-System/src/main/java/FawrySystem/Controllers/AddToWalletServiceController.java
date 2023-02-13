package FawrySystem.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Services.AddToWalletService.AddToWalletServiceBSL;
import FawrySystem.Models.ProviderServiceForm.FormRequest.AddToWalletFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;

@RestController
@RequestMapping("Service/AddToWalletService")
public class AddToWalletServiceController extends ServiceController{
	
	public AddToWalletServiceController() {
		this.serviceBSL = ApplicationContextHolder.getContext().getBean(AddToWalletServiceBSL.class);
	}
	
	@PostMapping("/ProcessService")
	public ResponseEntity<ProviderFormRespond> ProcessAddToWalletService(
			@RequestBody AddToWalletFormRequest formRequest) {
		return this.ProcessService(formRequest);
	}
}
