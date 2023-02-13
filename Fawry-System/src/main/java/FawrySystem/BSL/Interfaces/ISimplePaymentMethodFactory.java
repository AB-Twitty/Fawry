package FawrySystem.BSL.Interfaces;

import FawrySystem.Enums.PaymentMethodType;
import FawrySystem.Exceptions.EtException;

public interface ISimplePaymentMethodFactory {
	
	public IPaymentMethodBSL GetPayment(PaymentMethodType type) throws EtException;
}
