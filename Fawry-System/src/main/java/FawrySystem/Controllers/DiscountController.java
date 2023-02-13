package FawrySystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FawrySystem.BSL.Discounts.ISimpleDiscountFactory;
import FawrySystem.Models.DiscountRequest;
import FawrySystem.Models.TransactionRespond;

@RestController
@RequestMapping("/Discount")
public class DiscountController {
	
	@Autowired
	private ISimpleDiscountFactory discountFactory;
	
	@PostMapping("/ApplyTransactionDiscount")
	public ResponseEntity<TransactionRespond> ApplyDiscountTransaction(@RequestBody DiscountRequest request) {
		return new ResponseEntity<>(
				this.discountFactory.GetDiscount(request.getType()).ProcessDiscount(request),
				HttpStatus.OK);
	}
}
