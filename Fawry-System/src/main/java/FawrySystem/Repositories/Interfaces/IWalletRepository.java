package FawrySystem.Repositories.Interfaces;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.Wallet;

public interface IWalletRepository {
	
	public Integer Create(int userId) throws EtException; 

	public Wallet GetById(int id) throws EtException;
	
	public Wallet GetByUserId(int userId) throws EtException;
	
}
