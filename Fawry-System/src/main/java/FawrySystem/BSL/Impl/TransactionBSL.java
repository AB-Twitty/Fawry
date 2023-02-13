package FawrySystem.BSL.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FawrySystem.ApplicationContextHolder;
import FawrySystem.BSL.Interfaces.IPaymentMethodBSL;
import FawrySystem.BSL.Interfaces.ISimplePaymentMethodFactory;
import FawrySystem.BSL.Interfaces.ITransactionBSL;
import FawrySystem.BSL.Services.IServiceBSL;
import FawrySystem.BSL.Services.MobileServices.MobileServiceBSL;
import FawrySystem.Enums.PaymentMethodType;
import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Exceptions.EtBadRequestException;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Exceptions.EtNotFoundException;
import FawrySystem.Models.Discount;
import FawrySystem.Models.IPaymentMethod;
import FawrySystem.Models.TransactionRequest;
import FawrySystem.Models.TransactionRespond;
import FawrySystem.Models.Wallet;
import FawrySystem.Models.ProviderServiceForm.FormRespond.ProviderFormRespond;
import FawrySystem.Repositories.Interfaces.ITransactionRepository;

@Service
public class TransactionBSL implements ITransactionBSL{

	@Autowired
	private ISimplePaymentMethodFactory paymentFactory;
	
	@Autowired
	private ITransactionRepository transactionRepo;
	
	private IServiceBSL serviceBSL;
	 
	public TransactionBSL() {
		this.serviceBSL = ApplicationContextHolder.getContext().getBean(MobileServiceBSL.class);
	}
	
	
	@Override
	public TransactionRespond StartTransaction(TransactionRequest request, int userId) throws EtException{
		IPaymentMethodBSL paymentBSL = this.paymentFactory.GetPayment(request.getPaymentType());
		IPaymentMethod payment = paymentBSL.GetPaymentMethodById(request.getPaymentId());
		ProviderFormRespond service = serviceBSL.GetServiceById(request.getServiceId());
		TransactionRespond respond = new TransactionRespond(
				request.getServiceId(),
				request.getPaymentType()
				);
		respond.setPayment(payment);
		respond.setUserId(userId);
		respond.setCreationDate(new Date());
		respond.setLastModifiedDate(new Date());
		respond.setTotalAmount(service.getTotalAmount() + respond.getFees());
		respond.setPaymentId(request.getPaymentId());
		respond.setStatus(TransactionStatus.pending);
		return this.CreatTransaction(respond);
	}


	@Override
	public TransactionRespond CreatTransaction(TransactionRespond transaction) throws EtException {
		TransactionRespond respond = this.transactionRepo.Create(transaction);
		if (respond==null)
			throw new EtBadRequestException("Bad Request");
		return respond;
	}


	@Override
	public TransactionRespond GetTransactionById(int id) throws EtException {
		TransactionRespond respond = this.transactionRepo.GetById(id);
		if (respond==null)
			throw new EtNotFoundException("Not Found");
		return respond;
	}


	@Override
	public List<TransactionRespond> GetTranactionsByUserId(int userId) {
		return this.transactionRepo.GetByUserId(userId);
	}


	@Override
	public void UpdateTransactionStatus(TransactionStatus status, int id) throws EtException {
		TransactionRespond transaction = this.GetTransactionById(id);
		IPaymentMethodBSL paymentBSL = this.paymentFactory.GetPayment(PaymentMethodType.Wallet);
		Wallet wallet = ((WalletBSL)paymentBSL).GetUserWallet(transaction.getUserId());
		paymentBSL.UpdateBalance(wallet.getId(), transaction.getTotalAmount());
		transaction.setStatus(status);
		transaction.setLastModifiedDate(new Date());
	}


	@Override
	public TransactionRespond ApplyDiscount(Discount discount) throws EtException{
		TransactionRespond transaction = this.GetTransactionById(discount.getId());
		if (transaction.getStatus()!=TransactionStatus.pending) {
			throw new EtBadRequestException("Can Not Apply Discount On A Proceeded Transaction");
		}
		double amountDiscounted =  transaction.getTotalAmount() * (discount.getPercentage()/100);
		transaction.setTotalAmount(transaction.getTotalAmount()-amountDiscounted);
		transaction.setLastModifiedDate(new Date());
		return transaction;
	}


	@Override
	public List<TransactionRespond> GetTranactionsByUserIdAndStatus(int userId, TransactionStatus status) {
		return this.transactionRepo.GetByUserIdAndStatus(userId, status);
	}


	@Override
	public TransactionRespond ProceedTransaction(int transactionId) throws EtException {
		TransactionRespond transaction = this.GetTransactionById(transactionId);
		IPaymentMethodBSL paymentBSL = this.paymentFactory.GetPayment(transaction.getPaymentType());

		if (paymentBSL.CheckBalance(transaction.getPaymentId(),transaction.getTotalAmount())==false) {
			transaction.setStatus(TransactionStatus.Failed);
			return transaction;
		}
		paymentBSL.UpdateBalance(transaction.getPaymentId(),transaction.getTotalAmount()*-1);
		transaction.setStatus(TransactionStatus.Completed);
		transaction.setLastModifiedDate(new Date());
		return transaction;
	}

}
