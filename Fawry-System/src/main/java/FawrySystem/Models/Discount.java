package FawrySystem.Models;

import FawrySystem.Enums.DiscountType;

public class Discount {
	
	private int id;
	private double percentage;
	private DiscountType type;
	
	public Discount(double percentage, DiscountType type, int id) {
		super();
		this.percentage = percentage;
		this.type = type;
		this.id = id;
	}
	
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public DiscountType getType() {
		return type;
	}
	public void setType(DiscountType type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
