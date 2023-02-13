package FawrySystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.BSL.Interfaces.IWalletBSL;
import FawrySystem.Models.Wallet;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Wallet")
public class WalletController {

	@Autowired
	private IWalletBSL walletBSL;
	
	@GetMapping("/AddUserWallet")
	public ResponseEntity<Wallet> AddUserWallet(int userId) {
		return new ResponseEntity<>(walletBSL.AddWallet(userId),HttpStatus.CREATED);
	}
	
	@PostMapping("/AddToWallet/{balnce}")
	public ResponseEntity<Wallet> AddToWallet(HttpServletRequest request, @PathVariable double balance) {
		int userId = (Integer) request.getAttribute("userId");
		return new ResponseEntity<>(walletBSL.UpdateWalletBalance(userId, balance), HttpStatus.OK);
	}
	
	@GetMapping("/GetWallet")
	public ResponseEntity<Wallet> GetWallet(HttpServletRequest request) {
		int userId = (Integer) request.getAttribute("userId");
		return new ResponseEntity<>(walletBSL.GetUserWallet(userId),HttpStatus.OK);
	}
}
