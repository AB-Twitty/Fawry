package FawrySystem.BSL.Interfaces;

import java.util.List;

import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.RefundRequest;
import FawrySystem.Models.RefundRespond;

public interface IRefundBSL {

	public RefundRespond CreateTransactionRefund(int userId, int transactionId) throws EtException;
	
	public RefundRespond ProcessRefund(int adminId, RefundRequest refundRequest) throws EtException;
	
	public RefundRespond CreateRespond(RefundRespond refund) throws EtException;
	
	public RefundRespond GetRefundById(int id) throws EtException;
	
	public List<RefundRespond> GetPendingRefunds();
	
	public List<RefundRespond> GetRefundsByUser(int userId);

}
