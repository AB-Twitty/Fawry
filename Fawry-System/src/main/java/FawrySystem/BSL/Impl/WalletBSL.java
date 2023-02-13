package FawrySystem.BSL.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.BSL.Interfaces.IPaymentMethodBSL;
import FawrySystem.BSL.Interfaces.IWalletBSL;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.IPaymentMethod;
import FawrySystem.Models.Wallet;
import FawrySystem.Repositories.Interfaces.IWalletRepository;

@Service
public class WalletBSL implements IWalletBSL, IPaymentMethodBSL{
	
	@Autowired
	private IWalletRepository walletRepo;

	@Override
	public Wallet AddWallet(int userId) throws EtException {
		int id = walletRepo.Create(userId);
		return walletRepo.GetById(id);
	}

	@Override
	public Wallet GetUserWallet(int userId) throws EtException {
		return walletRepo.GetByUserId(userId);
	}

	@Override
	public Wallet UpdateWalletBalance(int userId, double balance) throws EtException {
		Wallet wallet = GetUserWallet(userId);
		wallet.setBalance(wallet.getBalance()+balance);
		return wallet;
	}
	

	@Override
	public Wallet GetWalletById(int id) throws EtException {
		Wallet wallet = this.walletRepo.GetById(id);
		if (wallet==null)
			throw new EtNotFoundException("Not Found");
		return wallet;
	}

	@Override
	public IPaymentMethod GetPaymentMethodById(int id) throws EtException {
		return this.GetWalletById(id);
	}

	@Override
	public boolean CheckBalance(int paymentId, double totalAmount) throws EtException{
		Wallet wallet = this.GetWalletById(paymentId);
		if (wallet.getBalance()<totalAmount)
			return false;
		return true;
	}

	@Override
	public void UpdateBalance(int paymentId, double balance) throws EtException{
		Wallet wallet = this.GetWalletById(paymentId);
		wallet.setBalance(wallet.getBalance()+balance);
	}

}
