package FawrySystem.Models;

import FawrySystem.Enums.AccountType;

public class RegistrationForm {

	private String name;
	private String username;
	private String email;
	private String password;
	private AccountType type;
	
	public RegistrationForm(String name, String username, String email, String password, AccountType type) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
}
