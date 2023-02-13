package FawrySystem.Repositories.Interfaces;

import FawrySystem.Models.Account;
import FawrySystem.Models.RegistrationForm;

public interface IAccountRepository {
	
	public Integer Create(RegistrationForm form);
	
	public Account GetByEmailAndPassword(String email, String password);
	
	public Account GetById(int id);
	
	public Integer GetCountByEmail(String email);
	
	public Integer GetCountByUsername(String username);
}
