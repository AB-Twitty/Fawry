package FawrySystem.Repositories.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import FawrySystem.Enums.RefundStatus;
import FawrySystem.Models.RefundRespond;
import FawrySystem.Repositories.Interfaces.IRefundRepository;

@Repository
public class RefundRepository implements IRefundRepository{

	private List<RefundRespond> refunds = new ArrayList<>();
	
	public RefundRepository() {
		
	}
	
	@Override
	public RefundRespond Create(RefundRespond refund) {
		int id = refunds.isEmpty() ? 0 : refunds.get(refunds.size()-1).getId();
		id++;
		refund.setId(id);
		refunds.add(refund);
		return GetById(id);
	}

	@Override
	public RefundRespond GetById(int id) {
		for (RefundRespond refund : refunds) {
			if (refund.getId()==id)
				return refund;
		}
		return null;
	}

	@Override
	public List<RefundRespond> GetByUserId(int userId) {
		List<RefundRespond> userRefunds = new ArrayList<>();
		for (RefundRespond refund : refunds) {
			if (refund.getUserId()==userId)
				userRefunds.add(refund);
		}
		return userRefunds;
	}

	@Override
	public List<RefundRespond> GetByStatus(RefundStatus status) {
		List<RefundRespond> Refunds = new ArrayList<>();
		for (RefundRespond refund : refunds) {
			if (refund.getStatus()==status)
				Refunds.add(refund);
		}
		return Refunds;
	}

}
