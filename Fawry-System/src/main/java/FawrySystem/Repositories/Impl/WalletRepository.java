package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.Wallet;
import FawrySystem.Repositories.Interfaces.IWalletRepository;

@Repository
public class WalletRepository implements IWalletRepository{

	private List<Wallet> wallets = new ArrayList<>();
	public WalletRepository() {
		wallets.add(new Wallet(1,1,50.6));
		wallets.add(new Wallet(2,2,25.0));
	}
	
	@Override
	public Integer Create(int userId){
		int id = wallets.get(wallets.size()-1).getId();
		id++;
		for (Wallet wallet : wallets) {
			if (wallet.getUserId()==userId)
				return null;
		}
		wallets.add(new Wallet(id,userId,0.0));
		return null;
	}

	@Override
	public Wallet GetById(int id) throws EtException {
		for (Wallet wallet : wallets) {
			if (wallet.getId()==id)
				return wallet;
		}
		throw new EtNotFoundException("No Wallet With That ID");
	}

	@Override
	public Wallet GetByUserId(int userId) throws EtException {
		for (Wallet wallet : wallets) {
			if (wallet.getUserId()==userId)
				return wallet;
		}
		throw new EtNotFoundException("This User Has No Wallet");
	}

	

}
