package FawrySystem.Repositories.Interfaces;

import java.util.List;

import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Models.TransactionRespond;

public interface ITransactionRepository {
	
	public TransactionRespond Create(TransactionRespond transaction);
	
	public TransactionRespond GetById(int id);
	
	public List<TransactionRespond> GetByUserId(int userId);
	
	public List<TransactionRespond> GetByUserIdAndStatus(int userId, TransactionStatus status);
}
