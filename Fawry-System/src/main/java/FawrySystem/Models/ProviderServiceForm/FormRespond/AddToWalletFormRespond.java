package FawrySystem.Models.ProviderServiceForm.FormRespond;

import FawrySystem.Enums.ProviderType;
import FawrySystem.Models.CreditCard;
import FawrySystem.Models.Wallet;

public class AddToWalletFormRespond extends ProviderFormRespond{
	
	public AddToWalletFormRespond(double amount, ProviderType type, Wallet wallet, CreditCard creditCard) {
		super(amount, 1.5, type);
		this.wallet = wallet;
		this.creditCard = creditCard;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	private Wallet wallet;
	private CreditCard creditCard;
	
	
}
