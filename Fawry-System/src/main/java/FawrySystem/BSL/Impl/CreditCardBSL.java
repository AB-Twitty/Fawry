package FawrySystem.BSL.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.BSL.Interfaces.ICreditCardBSL;
import FawrySystem.BSL.Interfaces.IPaymentMethodBSL;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.CreditCard;
import FawrySystem.Models.IPaymentMethod;
import FawrySystem.Repositories.Interfaces.ICreditCardRepository;

@Service
public class CreditCardBSL implements IPaymentMethodBSL, ICreditCardBSL{

	@Autowired
	private ICreditCardRepository creditCardRepo;
	
	
	@Override
	public IPaymentMethod GetPaymentMethodById(int id) throws EtException {
		return this.GetCreditCardById(id);
	}

	@Override
	public boolean CheckBalance(int paymentId, double totalAmount) throws EtException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void UpdateBalance(int paymentId, double balance) throws EtException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CreditCard AddCreditCard(int userId, String cardNum) throws EtException {
		CreditCard card = this.creditCardRepo.Create(userId, cardNum);
		if (card == null)
			throw new EtBadRequestException("Bad Request");
		return card;
	}

	@Override
	public CreditCard GetCreditCardById(int id) throws EtException {
		CreditCard card = this.creditCardRepo.GetById(id);
		if (card == null)
			throw new EtNotFoundException("Not Found");
		return card;
	}

	@Override
	public List<CreditCard> GetUserCreditCards(int userId) {
		return this.creditCardRepo.GetByUserId(userId);
	}

	@Override
	public CreditCard UpdateCreditCardBalance(int id, double balance) throws EtException {
		CreditCard card = this.GetCreditCardById(id);
		//card.setBalance(card.getBalance()+balance);
		return card;
	}

}
