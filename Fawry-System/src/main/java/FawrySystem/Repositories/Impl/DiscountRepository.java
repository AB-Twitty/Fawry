package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Enums.DiscountType;
import FawrySystem.Models.Discount;
import FawrySystem.Repositories.Interfaces.IDiscountRepository;

@Repository
public class DiscountRepository implements IDiscountRepository{

	private List<Discount> discounts = new ArrayList<>();
	
	public DiscountRepository() {
		discounts.add(new Discount(10.0,DiscountType.Overral,1));
		discounts.add(new Discount(7.5,DiscountType.Mobile,2));
		discounts.add(new Discount(2.5,DiscountType.Internet,3));
		discounts.add(new Discount(5.0,DiscountType.Landline,4));
		discounts.add(new Discount(3.0,DiscountType.Donnation,5));
	}
	
	
	@Override
	public Discount GetDiscountByType(DiscountType type) {
		for (Discount discount : discounts) {
			if (discount.getType()==type)
				return discount;
		}
		return null;
	}

	@Override
	public Discount GetDiscountById(int id) {
		for (Discount discount : discounts) {
			if (discount.getId()==id)
				return discount;
		}
		return null;
	}

}
