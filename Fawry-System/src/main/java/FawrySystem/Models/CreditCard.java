package FawrySystem.Models;

public class CreditCard implements IPaymentMethod{
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public CreditCard(int id, int userId, String cardNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.cardNum = cardNum;
	}
	private int id;
	private String cardNum;
	private int userId;
}
