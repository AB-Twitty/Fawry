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

import FawrySystem.BSL.Interfaces.IRefundBSL;
import FawrySystem.Models.RefundRequest;
import FawrySystem.Models.RefundRespond;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Refund")
public class RefundController {

	@Autowired
	private IRefundBSL refundBSL;
	
	@PostMapping("/CreateTransactionRefund/{transactionId}")
	public ResponseEntity<RefundRespond> CreateTransactionRefund(HttpServletRequest request,
			@PathVariable int transactionId) {
		int userId = (Integer) request.getAttribute("userId");
		return new ResponseEntity<>(
				this.refundBSL.CreateTransactionRefund(userId,transactionId),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/ProcessRefund")
	public ResponseEntity<RefundRespond> ProcessRefund(HttpServletRequest request,
			@RequestBody RefundRequest refundRequest){
		int adminId = (Integer) request.getAttribute("userId");
		return new ResponseEntity<>(
				this.refundBSL.ProcessRefund(adminId,refundRequest),
				HttpStatus.OK);
	}
	
	@GetMapping("/GetRefund/{id}")
	public ResponseEntity<RefundRespond> GetRefund(@PathVariable int id) {
		return new ResponseEntity<>(
				this.refundBSL.GetRefundById(id),
				HttpStatus.OK);
	}
	
	@GetMapping("/GetPendingRefunds")
	public ResponseEntity<List<RefundRespond>> GetPendingRefunds() {
		return new ResponseEntity<>(
				this.refundBSL.GetPendingRefunds(),
				HttpStatus.OK);
	}
}
