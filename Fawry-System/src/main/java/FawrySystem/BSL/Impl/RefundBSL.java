package FawrySystem.BSL.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.BSL.Interfaces.IRefundBSL;
import FawrySystem.BSL.Interfaces.ITransactionBSL;
import FawrySystem.Enums.RefundStatus;
import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.RefundRequest;
import FawrySystem.Models.RefundRespond;
import FawrySystem.Models.TransactionRespond;
import FawrySystem.Repositories.Interfaces.IRefundRepository;

@Service
public class RefundBSL implements IRefundBSL{

	@Autowired
	private ITransactionBSL transactionBSL;
	
	@Autowired
	private IRefundRepository refundRepo;
	
	@Override
	public RefundRespond CreateTransactionRefund(int userId, int transactionId) throws EtException {
		TransactionRespond transaction = this.transactionBSL.GetTransactionById(transactionId);
		RefundRespond respond = new RefundRespond(
				userId,
				transactionId,
				transaction.getTotalAmount(),
				RefundStatus.Pending);
		return this.CreateRespond(respond);
	}

	@Override
	public RefundRespond CreateRespond(RefundRespond refund) throws EtException {
		RefundRespond respond = this.refundRepo.Create(refund);
		if (respond==null)
			throw new EtBadRequestException("Bad Request");
		return respond;
	}

	@Override
	public RefundRespond GetRefundById(int id) throws EtException {
		RefundRespond respond = this.refundRepo.GetById(id);
		if (respond==null)
			throw new EtNotFoundException("Not Found");
		return respond;
	}

	@Override
	public List<RefundRespond> GetPendingRefunds() {
		return this.refundRepo.GetByStatus(RefundStatus.Pending);
	}

	@Override
	public List<RefundRespond> GetRefundsByUser(int userId) {
		return this.refundRepo.GetByUserId(userId);
	}

	@Override
	public RefundRespond ProcessRefund(int adminId, RefundRequest refundRequest) throws EtException {
		RefundRespond refund = this.GetRefundById(refundRequest.getId());
		if (refundRequest.getStatus()==RefundStatus.Accepted) {
			this.transactionBSL.UpdateTransactionStatus(TransactionStatus.Refunded,refund.getTransactionId());
		}
		refund.setAdminId(adminId);
		refund.setStatus(refundRequest.getStatus());
		return refund;
	}

}
