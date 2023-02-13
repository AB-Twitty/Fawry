package FawrySystem.BSL.Interfaces;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.Account;
import FawrySystem.Models.RegistrationForm;

public interface IAccountBSL {
	
	public Account RegisterUser(RegistrationForm form) throws EtException;
	
	public Account LoginUser(String email, String password) throws EtException;
	
	public Account CheckUserExistence(String email, String password);
	
}
