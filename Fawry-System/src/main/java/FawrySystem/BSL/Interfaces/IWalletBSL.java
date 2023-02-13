package FawrySystem.BSL.Interfaces;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.Wallet;

public interface IWalletBSL {
	
	public Wallet AddWallet(int userId) throws EtException;
	
	public Wallet GetWalletById(int id) throws EtException;
	
	public Wallet GetUserWallet(int userId) throws EtException;
	
	public Wallet UpdateWalletBalance(int userId, double balance) throws EtException;
}
