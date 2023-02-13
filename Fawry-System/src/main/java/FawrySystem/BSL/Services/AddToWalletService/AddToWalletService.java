package FawrySystem.BSL.Services.AddToWalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import FawrySystem.BSL.Interfaces.ICreditCardBSL;
import FawrySystem.BSL.Interfaces.IWalletBSL;
import FawrySystem.BSL.Services.IService;
import FawrySystem.Enums.AddToWalletServiceType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.CreditCard;
import FawrySystem.Models.Wallet;
import FawrySystem.Models.ProviderServiceForm.FormRequest.AddToWalletFormRequest;
import FawrySystem.Models.ProviderServiceForm.FormRespond.AddToWalletFormRespond;

@Component
public class AddToWalletService implements IService<AddToWalletFormRequest,AddToWalletFormRespond>{

	@Autowired
	private IWalletBSL walletBSL;
	
	@Autowired
	private ICreditCardBSL creditCardBSL; 
	
	@Override
	public AddToWalletFormRespond Handle(AddToWalletFormRequest formRequest) throws EtException {
		Wallet wallet = this.walletBSL.GetWalletById(formRequest.getWalletId());
		CreditCard card = this.creditCardBSL.GetCreditCardById(formRequest.getWalletId());
		AddToWalletFormRespond formRespond = new AddToWalletFormRespond(
				formRequest.getAmount(),
				AddToWalletServiceType.AddToWallet,
				wallet,
				card);
		double totalAmount = formRequest.getAmount() + formRespond.getFees();
		formRespond.setTotalAmount(totalAmount);
		return formRespond;
	}

}
