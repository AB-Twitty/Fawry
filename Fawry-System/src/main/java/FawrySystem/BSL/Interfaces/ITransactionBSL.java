package FawrySystem.BSL.Interfaces;

import java.util.List;

import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Exceptions.EtException;
import FawrySystem.Models.Discount;
import FawrySystem.Models.TransactionRequest;
import FawrySystem.Models.TransactionRespond;

public interface ITransactionBSL {

	public TransactionRespond StartTransaction(TransactionRequest request, int userId) throws EtException;
	
	public void UpdateTransactionStatus(TransactionStatus status, int id) throws EtException;
	
	public TransactionRespond CreatTransaction(TransactionRespond transaction) throws EtException;
	
	public TransactionRespond ProceedTransaction(int transactionId) throws EtException;
	
	public TransactionRespond GetTransactionById(int id) throws EtException;
	
	public List<TransactionRespond> GetTranactionsByUserId(int userId);
	
	public List<TransactionRespond> GetTranactionsByUserIdAndStatus(int userId, TransactionStatus status);

	public TransactionRespond ApplyDiscount(Discount discount);
}
