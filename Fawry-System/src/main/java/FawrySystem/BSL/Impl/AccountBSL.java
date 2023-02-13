package FawrySystem.BSL.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.BSL.Interfaces.IAccountBSL;
import FawrySystem.Exceptions.EtAuthException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.Account;
import FawrySystem.Models.RegistrationForm;
import FawrySystem.Repositories.Interfaces.IAccountRepository;

@Service
public class AccountBSL implements IAccountBSL{
	
	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public Account RegisterUser(RegistrationForm form) throws EtException {
		/*Pattern pattern = Pattern.compile("^(.+)$(.+)$");
		if (!pattern.matcher(email).matches())
			throw new EtAuthException("Invalid Email Format");*/
		
		if (accountRepo.GetCountByEmail(form.getEmail())>0)
			throw new EtAuthException("Email Already In Use");
		
		if (accountRepo.GetCountByUsername(form.getUsername())>0)
			throw new EtAuthException("Username Already In Use");
		
		int userId = accountRepo.Create(form);
		return accountRepo.GetById(userId);
	}

	@Override
	public Account LoginUser(String email, String password) throws EtException {
		Account account = accountRepo.GetByEmailAndPassword(email, password);
		
		if (account==null)
			throw new EtAuthException("Invalid Email/Password");
		
		return account;
	}

	@Override
	public Account CheckUserExistence(String email, String password) {
		return this.accountRepo.GetByEmailAndPassword(email, password);
	}

}
