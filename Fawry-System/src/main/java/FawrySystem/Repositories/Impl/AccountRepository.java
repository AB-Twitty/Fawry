package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import FawrySystem.Enums.AccountType;
import FawrySystem.Models.Account;
import FawrySystem.Models.RegistrationForm;
import FawrySystem.Repositories.Interfaces.IAccountRepository;

@Repository
public class AccountRepository implements IAccountRepository{

	private final List<Account> accounts = new ArrayList<>();
	public AccountRepository() {
		accounts.add(new Account(1,"Ahmed Ali","ahmed", "ahmed@gmail.com", //password = 123456
				"$2a$10$YXaln7aClD/WNa4viJTIOuM02yUB/60eg0xILP8AmJuwGfmoXLomy", AccountType.User));
		accounts.add(new Account(2,"admin","admin", "admin@gmail.com", //password = admin
				"$2a$10$bKQkXUOcZUzW169nC94CmOHrk0xYYrOFd0zvpNZr/TezMs3BhPreS", AccountType.Admin));
	}
	
	@Override
	public Integer Create(RegistrationForm form) {
		int id = accounts.get(accounts.size()-1).getId();
		id++;
		String hashPassword = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(10));
		accounts.add(new Account(id, 
				form.getName(), 
				form.getUsername(), 
				form.getEmail(),
				hashPassword,
				AccountType.User));
		return id;
	}

	@Override
	public Account GetByEmailAndPassword(String email, String password) {
		for (Account account : accounts) {
			if (account.getEmail().equals(email) && BCrypt.checkpw(password, account.getHashPassword()))
				return account;
		}
		return null;
	}

	@Override
	public Account GetById(int id) {
		for (Account account : accounts) {
			if (account.getId() == id)
				return account;
		}
		return null;
	}

	@Override
	public Integer GetCountByEmail(String email) {
		int count = 0;
		for (Account account : accounts) {
			if (account.getEmail().equals(email))
				count++;
		}
		return count;
	}
	
	@Override
	public Integer GetCountByUsername(String username) {
		int count = 0;
		for (Account account : accounts) {
			if (account.getEmail().equals(username))
				count++;
		}
		return count;
	}

}
