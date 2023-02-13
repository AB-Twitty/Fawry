package FawrySystem.BSL.Discounts;

import org.springframework.stereotype.Service;

import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.DiscountRequest;
import FawrySystem.Models.TransactionRespond;

@Service
public class OverralDiscountBSL extends DiscountBSL{

	@Override
	public void ValidateDiscount(DiscountRequest request) throws EtException {
		TransactionRespond transaction = this.transactionBSL.GetTransactionById(request.getTransactionId());
		if (this.transactionBSL.GetTranactionsByUserIdAndStatus(transaction.getUserId(),TransactionStatus.Completed).size()>1)
			throw new EtBadRequestException("Bad Request: This Is Not The User First Transaction");
	}

}
