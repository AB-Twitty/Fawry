package FawrySystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.BSL.Interfaces.ITransactionBSL;
import FawrySystem.Models.TransactionRequest;
import FawrySystem.Models.TransactionRespond;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

	@Autowired
	private ITransactionBSL transactionBSL;
	
	@PostMapping("/CreateTransaction")
	public ResponseEntity<TransactionRespond> CreateTransaction(HttpServletRequest request
			,@RequestBody TransactionRequest transactionRequest) {
		int userId = (Integer) request.getAttribute("userId");
		return new ResponseEntity<>(
				this.transactionBSL.StartTransaction(transactionRequest, userId),
				HttpStatus.OK);
	}
	
	@GetMapping("/ProceedTransaction/{transactionId}")
	public ResponseEntity<TransactionRespond> ProceedTransaction(@PathVariable int transactionId) {
		return new ResponseEntity<>(
				this.transactionBSL.ProceedTransaction(transactionId),
				HttpStatus.OK);
	}
	
	@GetMapping("/GetUserTransactions/{userId}")
	public ResponseEntity<List<TransactionRespond>> GetUserTransactions(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(
				this.transactionBSL.GetTranactionsByUserId(userId),
				HttpStatus.OK);
	}
	
	@GetMapping("/GetTransaction/{id}")
	public ResponseEntity<TransactionRespond> GetTransaction(@PathVariable int id) {
		return new ResponseEntity<>(
				this.transactionBSL.GetTransactionById(id),
				HttpStatus.OK);
	}
}
