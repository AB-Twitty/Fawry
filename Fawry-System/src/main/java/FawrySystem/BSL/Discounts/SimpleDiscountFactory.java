package FawrySystem.BSL.Discounts;

import org.springframework.stereotype.Component;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.Enums.DiscountType;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;

@Component
public class SimpleDiscountFactory implements ISimpleDiscountFactory{

	@Override
	public DiscountBSL GetDiscount(DiscountType type) throws EtException {
		switch (type) {
			case Overral:
				return ApplicationContextHolder.getContext().getBean(OverralDiscountBSL.class);
			default:
				throw new EtBadRequestException("Type: " + type + "Not Supported");
		}
	}

}
