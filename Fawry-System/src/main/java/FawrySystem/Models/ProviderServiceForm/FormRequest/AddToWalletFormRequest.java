package FawrySystem.Models.ProviderServiceForm.FormRequest;

import FawrySystem.Enums.AddToWalletServiceType;

public class AddToWalletFormRequest extends ProviderFormRequest{

	public AddToWalletFormRequest(double amount, AddToWalletServiceType type, int walletId, int creditCardId) {
		super(amount, type);
		this.walletId = walletId;
		this.creditCardId = creditCardId;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}
	private int walletId;
	private int creditCardId;
	
}
