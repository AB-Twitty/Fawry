package FawrySystem.BSL.Impl;

import org.springframework.stereotype.Component;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Interfaces.IPaymentMethodBSL;
import FawrySystem.BSL.Interfaces.ISimplePaymentMethodFactory;
import FawrySystem.Enums.PaymentMethodType;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;

@Component
public class SimplePaymentMethodFactory implements ISimplePaymentMethodFactory{
	
	@Override
	public IPaymentMethodBSL GetPayment(PaymentMethodType type) throws EtException {
		switch (type) {
			case Wallet:
				return ApplicationContextHolder.getContext().getBean(WalletBSL.class);
			case CreditCard:
				return ApplicationContextHolder.getContext().getBean(CreditCardBSL.class);
			default:
				throw new EtNotFoundException("Type: " + type + "Not Supported");
		}
	}

}
