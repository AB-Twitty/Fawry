package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Models.CreditCard;
import FawrySystem.Repositories.Interfaces.ICreditCardRepository;

@Repository
public class CreditCardRepository implements ICreditCardRepository{

	private List<CreditCard> cards = new ArrayList<>();
	
	public CreditCardRepository() {
		cards.add(new CreditCard(1,1,"1234567891236"));
		cards.add(new CreditCard(1,2,"1234567891263"));
	}
	
	@Override
	public CreditCard Create(int userId, String cardNum) {
		int id = cards.isEmpty() ? 0 : cards.get(cards.size()-1).getId();
		id++;
		cards.add(new CreditCard(id,userId,cardNum));
		return GetById(id);
	}

	@Override
	public CreditCard GetById(int id) {
		for (CreditCard card : cards) {
			if (card.getId()==id)
				return card;
		}
		return null;
	}

	@Override
	public List<CreditCard> GetByUserId(int userId) {
		List<CreditCard>  userCards = new ArrayList<>();
		for (CreditCard card : cards) {
			if (card.getUserId()==userId)
				userCards.add(card);
		}
		return userCards;
	}

}
