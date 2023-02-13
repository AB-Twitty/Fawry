package FawrySystem.Models;

import FawrySystem.Enums.DiscountType;

public class DiscountRequest {
	
	private int transactionId;
	private int discountId;
	private DiscountType type;
	
	public DiscountRequest(int transactionId, int discountId, DiscountType type) {
		super();
		this.transactionId = transactionId;
		this.discountId = discountId;
		this.type = type;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public DiscountType getType() {
		return type;
	}

	public void setType(DiscountType type) {
		this.type = type;
	}

}
