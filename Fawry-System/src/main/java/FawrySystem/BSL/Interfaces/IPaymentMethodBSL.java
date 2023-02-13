package FawrySystem.BSL.Interfaces;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.IPaymentMethod;

public interface IPaymentMethodBSL {

	public IPaymentMethod GetPaymentMethodById(int id) throws EtException;

	public boolean CheckBalance(int paymentId, double totalAmount) throws EtException;

	public void UpdateBalance(int paymentId, double balance) throws EtException;
	
	
}
