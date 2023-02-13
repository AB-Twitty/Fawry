package FawrySystem.Repositories.Interfaces;

import FawrySystem.Enums.DiscountType;
import FawrySystem.Models.Discount;

public interface IDiscountRepository {

	public Discount GetDiscountByType(DiscountType type);
	
	public Discount GetDiscountById(int id);
}
