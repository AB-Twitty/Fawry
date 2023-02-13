package FawrySystem.BSL.Discounts;

import FawrySystem.Enums.DiscountType;
import FawrySystem.Exceptions.EtException;

public interface ISimpleDiscountFactory {
	
	public DiscountBSL GetDiscount(DiscountType type) throws EtException;
}
