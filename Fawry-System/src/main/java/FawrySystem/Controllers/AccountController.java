package FawrySystem.Controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.Helpers;
import FawrySystem.BSL.Interfaces.IAccountBSL;
import FawrySystem.Models.Account;
import FawrySystem.Models.RegistrationForm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/Account")
public class AccountController {
	
	@Autowired
	private IAccountBSL accountBSL;
	
	@PostMapping("/Register")
	public ResponseEntity<Map<String,Object>> Register(@RequestBody RegistrationForm form) {
		Account account = accountBSL.RegisterUser(form);
		Map<String,Object> accountInfo = new HashMap<>();
		accountInfo.put("account", account);
		accountInfo.putAll(GenerateJWTToken(account));
		ApplicationContextHolder.getContext().getBean(WalletController.class).AddUserWallet(account.getId());
		return new ResponseEntity<>(accountInfo, HttpStatus.OK);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<Map<String,Object>> Login(@RequestBody Map<String,Object> map) {
		String email = (String) map.get("email");
		String password = (String) map.get("password");
		Account account = accountBSL.LoginUser(email, password);
		Map<String,Object> accountInfo = new HashMap<>();
		accountInfo.put("account", account);
		accountInfo.putAll(GenerateJWTToken(account));
		return new ResponseEntity<>(accountInfo, HttpStatus.OK);
	}
	
	@GetMapping("/CheckExistence")
	public ResponseEntity<Account> CheckExistence(@RequestBody Map<String,Object> map) {
		String email = (String) map.get("email");
		String password = (String) map.get("password");
		return new ResponseEntity<>(
				this.accountBSL.CheckUserExistence(email,password),
				HttpStatus.OK);
	}
	
	private Map<String,String> GenerateJWTToken(Account account) {
		long timestamp = System.currentTimeMillis();
		String token = Jwts.builder()
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp + Helpers.TOKEN_VALIDITY))
				.claim("userId", account.getId())
				.signWith(SignatureAlgorithm.HS256, Helpers.API_SECRET_KEY)
				.compact();
		Map<String,String> map = new HashMap<>();
		map.put("token",token);
		return map;
	}
}
