package FawrySystem.BSL.Interfaces;

import java.util.List;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.CreditCard;

public interface ICreditCardBSL {

	public CreditCard AddCreditCard(int userId, String cardNum) throws EtException;
	
	public CreditCard GetCreditCardById(int id) throws EtException;
	
	public List<CreditCard> GetUserCreditCards(int userId);
	
	public CreditCard UpdateCreditCardBalance(int id, double balance) throws EtException;
}
