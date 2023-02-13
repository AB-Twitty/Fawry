package FawrySystem.Repositories.Interfaces;

import java.util.List;

import FawrySystem.Models.CreditCard;

public interface ICreditCardRepository {
	
	public CreditCard Create(int userId, String cardNum); 

	public CreditCard GetById(int id);
	
	public List<CreditCard> GetByUserId(int userId);
}
