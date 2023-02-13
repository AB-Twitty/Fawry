package FawrySystem.BSL.Discounts;

import org.springframework.beans.factory.annotation.Autowired;

import FawrySystem.BSL.Interfaces.ITransactionBSL;
import FawrySystem.Enums.DiscountType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.Discount;
import FawrySystem.Models.DiscountRequest;
import FawrySystem.Models.TransactionRespond;
import FawrySystem.Repositories.Interfaces.IDiscountRepository;

public abstract class DiscountBSL {
	
	@Autowired
	protected IDiscountRepository discountRepository;
	
	@Autowired
	protected ITransactionBSL transactionBSL;
	
	public abstract void ValidateDiscount(DiscountRequest request) throws EtException; 
	
	public TransactionRespond ProcessDiscount(DiscountRequest request) throws EtException {
		Discount discount = this.GetDiscountById(request.getDiscountId());
		this.ValidateDiscount(request);
		return this.transactionBSL.ApplyDiscount(discount);
	}
	
	public Discount GetDiscountByType(DiscountType type) throws EtException {
		Discount discount =  this.discountRepository.GetDiscountByType(type);
		if (discount == null)
			throw new EtNotFoundException("Not Found");
		return discount;
	}
	
	public Discount GetDiscountById(int id) throws EtException {
		Discount discount =  this.discountRepository.GetDiscountById(id);
		if (discount == null)
			throw new EtNotFoundException("Not Found");
		return discount;
	}
	
}
