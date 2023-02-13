package FawrySystem.Models;

import FawrySystem.Enums.AccountType;

public class Account {
	private int id = 0;
	private String name;
	private String username;
	private String email;
	private String hashPassword;
	private AccountType type;
	
	public Account(int id, String name, String username, String email, String hashPassword, AccountType type) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.hashPassword = hashPassword;
		this.type = type;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getHashPassword() {
		return this.hashPassword;
	}
	
	public AccountType getAccountType() {
		return this.type;
	}
}
