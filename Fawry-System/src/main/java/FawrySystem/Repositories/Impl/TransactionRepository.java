package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Enums.TransactionStatus;
import FawrySystem.Models.TransactionRespond;
import FawrySystem.Repositories.Interfaces.ITransactionRepository;

@Repository
public class TransactionRepository implements ITransactionRepository{

	private List<TransactionRespond> transactions = new ArrayList<>();
	
	public TransactionRepository() {
		
	}
	
	@Override
	public TransactionRespond Create(TransactionRespond transaction) {
		int id = transactions.isEmpty() ? 0 : this.transactions.get(transactions.size()-1).getId();
		id++;
		transaction.setId(id);
		transactions.add(transaction);
		return this.GetById(id);
	}

	@Override
	public TransactionRespond GetById(int id) {
		for (TransactionRespond transaction : transactions) {
			if (transaction.getId() == id)
				return transaction;
		}
		return null;
	}

	@Override
	public List<TransactionRespond> GetByUserId(int userId) {
		List<TransactionRespond> userTransactions = new ArrayList<>();
		for (TransactionRespond transaction : transactions) {
			if (transaction.getUserId()==userId)
				userTransactions.add(transaction);
		}
		return userTransactions;
	}

	@Override
	public List<TransactionRespond> GetByUserIdAndStatus(int userId, TransactionStatus status) {
		List<TransactionRespond> userTransactions = new ArrayList<>();
		for (TransactionRespond transaction : transactions) {
			if (transaction.getUserId()==userId && transaction.getStatus()==status)
				userTransactions.add(transaction);
		}
		return userTransactions;
	}

}
